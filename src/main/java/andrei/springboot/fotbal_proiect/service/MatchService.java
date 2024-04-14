package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchRequest;
import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchResponse;
import andrei.springboot.fotbal_proiect.dto.rest.match.GetAllMatchesResponse;
import andrei.springboot.fotbal_proiect.entity.Match;

import java.util.List;

public interface MatchService {

    List<GetAllMatchesResponse> getAllMatches();

    Match getMatchById(Long id);

    List<Match> getAllUpcomingMatches();

    CreateMatchResponse createMatch(CreateMatchRequest request);
}
