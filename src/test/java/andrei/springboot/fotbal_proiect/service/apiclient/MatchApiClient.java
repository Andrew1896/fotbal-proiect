package andrei.springboot.fotbal_proiect.service.apiclient;

import andrei.springboot.fotbal_proiect.controller.MatchController;
import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchRequest;
import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchResponse;
import andrei.springboot.fotbal_proiect.dto.rest.match.GetAllMatchesResponse;
import andrei.springboot.fotbal_proiect.entity.Match;
import andrei.springboot.fotbal_proiect.service.common.BaseRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class MatchApiClient {

    private static final String SAVE_MATCH = "http://localhost:{PORT}/api/v1/matches";
    private static final String GET_ALL_MATCHES = "http://localhost:{PORT}/api/v1/matches";
    private static final String GET_MATCH_BY_ID = "http://localhost:{PORT}/api/v1/matches/{ID}";
    private static final String GET_ALL_UPCOMING_MATCHES = "http://localhost:{PORT}/api/v1/matches/upcoming";

    @Autowired
    private BaseRestTemplate baseRestTemplate;

    public CreateMatchResponse createMatch(String port, CreateMatchRequest match) {
        var response = baseRestTemplate.exchange(
                RequestEntity.post(SAVE_MATCH.replace("{PORT}", port))
                        .contentType(APPLICATION_JSON)
                        .body(match),
                new ParameterizedTypeReference<CreateMatchResponse>() {
                }
        );

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

        return response.getBody();
    }

    public Match getMatchById(String port, Long id) {
        var response = baseRestTemplate.exchange(
                RequestEntity.get(GET_MATCH_BY_ID
                        .replace("{PORT}", port)
                        .replace("{ID}", id.toString())
                ).build(),
                new ParameterizedTypeReference<Match>() {
                }
        );

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

        return response.getBody();
    }

    public List<GetAllMatchesResponse> getAllMatches(String port) {
        var response = baseRestTemplate.exchange(
                RequestEntity.get(GET_ALL_MATCHES.replace("{PORT}", port)).build(),
                new ParameterizedTypeReference<List<GetAllMatchesResponse>>() {
                }
        );

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

        return response.getBody();
    }

    public List<MatchController.UpcomingMatches> getAllUpcomingMatches(String port) {
        var response = baseRestTemplate.exchange(
                RequestEntity.get(GET_ALL_UPCOMING_MATCHES.replace("{PORT}", port)).build(),
                new ParameterizedTypeReference<List<MatchController.UpcomingMatches>>() {
                }
        );

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

        return response.getBody();
    }
}
