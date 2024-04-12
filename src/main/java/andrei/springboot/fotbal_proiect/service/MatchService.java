package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.entity.Match;

import java.util.List;

public interface MatchService {

    List<Match> getAllMatches();

    Match getMatchById(Long id);

    List<Match> getAllUpcomingMatches();
}
