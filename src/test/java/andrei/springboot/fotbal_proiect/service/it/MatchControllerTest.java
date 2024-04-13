package andrei.springboot.fotbal_proiect.service.it;

import andrei.springboot.fotbal_proiect.controller.MatchController.UpcomingMatches;
import andrei.springboot.fotbal_proiect.dao.MatchRepository;
import andrei.springboot.fotbal_proiect.entity.Match;
import andrei.springboot.fotbal_proiect.service.apiclient.MatchApiClient;
import andrei.springboot.fotbal_proiect.service.common.PostgresIntegrationTest;
import andrei.springboot.fotbal_proiect.service.utils.JsonReader;
import com.fasterxml.jackson.core.type.TypeReference;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

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
        List<Match> expectedMatchesTransient = JsonReader.read("db/mocks/match/allMatches.json", MATCH_LIST_TYPE_REFERENCE);
        List<Match> expectedMatchesPersisted = matchRepository.saveAll(expectedMatchesTransient);

        //        WHEN
        List<Match> allMatches = matchApiClient.getAllMatches(port);

        //        THEN
        assertThat(allMatches)
                .hasSize(2)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsAll(expectedMatchesPersisted);
    }

    @Test
    @DisplayName("Get match by id")
    void getMatchByIdTest() {
        //        GIVEN
        List<Match> expectedMatchesTransient = JsonReader.read("db/mocks/match/matchesByIdToPersist.json", MATCH_LIST_TYPE_REFERENCE);
        List<Match> expectedMatchesPersisted = matchRepository.saveAll(expectedMatchesTransient);

        //        WHEN
        Match matchFound = matchApiClient.getMatchById(port, expectedMatchesPersisted.get(1).getId());

        //        THEN
        Match expectedMatchResponse = JsonReader.read("db/mocks/match/matchesByIdResponse.json", MATCH_TYPE_REFERENCE);

        assertThat(matchFound)
                .usingRecursiveComparison(RecursiveComparisonConfiguration.builder()
                        .withIgnoredFields("id") // Ignores the 'id' field in comparison
                        .build())
                .isEqualTo(expectedMatchResponse);
    }

    @Test
    @DisplayName("Get all upcoming matches")
        // Este o problema in acest test ca vine si scorul, upcoming matches mereu au scorul 0:0, nu poate fi asa ceva ca un meci sa aiba deja scor daca inca nu s-a jucat
    void getAllUpcomingMatchesTest() {
        //        GIVEN
        List<Match> expectedMatchesTransient = JsonReader.read("db/mocks/match/upcomingMatchesToPersist.json", MATCH_LIST_TYPE_REFERENCE);
        matchRepository.saveAll(expectedMatchesTransient);

        //        WHEN
        List<UpcomingMatches> allMatches = matchApiClient.getAllUpcomingMatches(port);

        //        THEN
        List<UpcomingMatches> expectedMatchesResponse = JsonReader.read("db/mocks/match/upcomingMatchesResponse.json", MATCH_UPCOMING_LIST_TYPE_REFERENCE);

        assertThat(expectedMatchesResponse)
                .hasSize(2)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")  // Ignores the 'id' field in comparison
                .containsAll(allMatches);
    }

    //    @formatter:off
    private static final TypeReference<List<Match>> MATCH_LIST_TYPE_REFERENCE = new TypeReference<>() {};
    private static final TypeReference<List<UpcomingMatches>> MATCH_UPCOMING_LIST_TYPE_REFERENCE = new TypeReference<>() {};
    private static final TypeReference<Match> MATCH_TYPE_REFERENCE = new TypeReference<>() {};
}
