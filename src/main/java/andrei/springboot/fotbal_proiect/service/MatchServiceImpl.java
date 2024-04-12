package andrei.springboot.fotbal_proiect.service;

import andrei.springboot.fotbal_proiect.dao.MatchRepository;
import andrei.springboot.fotbal_proiect.entity.Match;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Meciul cu ID-ul: " + id + " nu a fost găsit"));
    }

    public List<Map<String, Object>> getAllUpcomingMatches() {
        List<Match> upcomingMatches = matchRepository.findByDate(LocalDate.now());
        List<Map<String, Object>> matchesJson = new ArrayList<>();
        for (Match match : upcomingMatches) {
            Map<String, Object> matchJson = new HashMap<>();
            matchJson.put("id", match.getId());
            matchJson.put("name", match.getName());
            matchJson.put("date", match.getDate());
            matchJson.put("location", match.getLocation());
            matchesJson.add(matchJson);
        }
        return matchesJson;
    }
}
