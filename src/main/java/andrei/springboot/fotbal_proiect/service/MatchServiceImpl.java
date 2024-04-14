package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.MatchRepository;
import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchRequest;
import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchResponse;
import andrei.springboot.fotbal_proiect.dto.rest.match.GetAllMatchesResponse;
import andrei.springboot.fotbal_proiect.entity.Match;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<GetAllMatchesResponse> getAllMatches() {
        return matchRepository.findAll()
                .stream()
                .map(GetAllMatchesResponse::fromEntity)
                .toList();
    }

    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Meciul cu ID-ul: " + id + " nu a fost găsit"));
    }

    @Override
    public List<Match> getAllUpcomingMatches() {
        return matchRepository.findByDateAfter(LocalDateTime.now());
    }

    @Override
    public CreateMatchResponse createMatch(CreateMatchRequest request) {
        Match match = request.toEntity();

        Match matchSaved = matchRepository.save(match);

        return CreateMatchResponse.fromEntity(matchSaved);
    }
}
