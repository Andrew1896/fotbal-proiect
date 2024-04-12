package andrei.springboot.fotbal_proiect.service.it;

import andrei.springboot.fotbal_proiect.dao.MatchRepository;
import andrei.springboot.fotbal_proiect.entity.Match;
import andrei.springboot.fotbal_proiect.service.common.BaseRestTemplate;
import andrei.springboot.fotbal_proiect.service.common.PostgresIntegrationTest;
import andrei.springboot.fotbal_proiect.service.utils.JsonReader;
import com.fasterxml.jackson.core.type.TypeReference;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;

import java.util.List;


@PostgresIntegrationTest
class MatchControllerTest {

    @LocalServerPort
    private String port;

    public String getBaseURL() {
        return "http://localhost:" + port;
    }

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private BaseRestTemplate baseRestTemplate;

    @Test
    void getAllMatchesTest() {
        List<Match> expectedMatches = JsonReader.read("mocks/match/allMatches.json", new TypeReference<>() {});
        matchRepository.saveAll(expectedMatches);

        String url = getBaseURL() + "/api/v1/matches";

        var response = baseRestTemplate.exchange(
                RequestEntity.get(url).build(),
                new ParameterizedTypeReference<List<Match>>() {
                }
        );

        Assertions.assertThat(response.getBody()).containsAll(expectedMatches);
    }

    @Test
    void getMatchByIdTest() {
        Match expectedMatch = JsonReader.read("mocks/match/matchesById.json", new TypeReference<>() {});
        matchRepository.save(expectedMatch);

        String url = getBaseURL() + "/api/v1/matches/%d".formatted(expectedMatch.getId());

        var response = baseRestTemplate.exchange(
                RequestEntity.get(url).build(),
                new ParameterizedTypeReference<Match>() {
                }
        );

        Assertions.assertThat(response.getBody()).isEqualTo(expectedMatch);
    }
}
