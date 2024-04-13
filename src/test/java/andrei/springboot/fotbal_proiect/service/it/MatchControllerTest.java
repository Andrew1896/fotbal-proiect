package andrei.springboot.fotbal_proiect.service.it;

import andrei.springboot.fotbal_proiect.dao.MatchRepository;
import andrei.springboot.fotbal_proiect.entity.Match;
import andrei.springboot.fotbal_proiect.service.apiclient.MatchApiClient;
import andrei.springboot.fotbal_proiect.service.common.PostgresIntegrationTest;
import andrei.springboot.fotbal_proiect.service.utils.JsonReader;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@PostgresIntegrationTest
class MatchControllerTest {

    @LocalServerPort
    private String port;

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchApiClient matchApiClient;

    @BeforeEach
    void setup() {
        matchRepository.deleteAll();
    }

    @Test
    @DisplayName("Get all matches")
    void getAllMatchesTest() {
        //        GIVEN
        List<Match> expectedMatchesTransient = JsonReader.read("db/mocks/allMatches.json", MATCH_LIST_TYPE_REFERENCE);
        List<Match> expectedMatchesPersisted = matchRepository.saveAll(expectedMatchesTransient);

        //        WHEN
        List<Match> allMatches = matchApiClient.getAllMatches(port);

        //        THEN
        assertThat(allMatches)
                .hasSize(2)
                .containsAll(expectedMatchesPersisted);
    }

    @Test
    @DisplayName("Get match by id")
    void getMatchByIdTest() {
        //        GIVEN
        Match expectedMatchTransient = JsonReader.read("db/mocks/matchesById.json", MATCH_TYPE_REFERENCE);
        Match expectedMatchPersisted = matchRepository.save(expectedMatchTransient);

        //        WHEN
        Match matchFound = matchApiClient.getMatchById(port, expectedMatchPersisted.getId());

        //        THEN
        assertThat(matchFound)
                .usingRecursiveComparison()
                .isEqualTo(expectedMatchPersisted);
    }

    @Test
    @DisplayName("Get all upcoming matches") // Este o problema in acest test ca vine si scorul, upcoming matches mereu au scorul 0:0, nu poate fi asa ceva ca un meci sa aiba deja scor daca inca nu s-a jucat
    void getAllUpcomingMatchesTest() {
        //        GIVEN
        List<Match> expectedMatchesTransient = JsonReader.read("db/mocks/upcomingMatches.json", MATCH_LIST_TYPE_REFERENCE);
        List<Match> expectedMatchesPersisted = matchRepository.saveAll(expectedMatchesTransient)
                .stream()
                .filter(match -> match.getDate().isAfter(LocalDateTime.now()))
                .toList();

        //        WHEN
        List<Match> allMatches = matchApiClient.getAllUpcomingMatches(port);

        //        THEN
        assertThat(expectedMatchesPersisted)
                .hasSize(2)
                .containsAll(allMatches);
    }

    //    @formatter:off
    private static final TypeReference<List<Match>> MATCH_LIST_TYPE_REFERENCE = new TypeReference<>() {};
    private static final TypeReference<Match> MATCH_TYPE_REFERENCE = new TypeReference<>() {};
}
