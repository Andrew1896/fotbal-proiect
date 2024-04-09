package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Match;
import andrei.springboot.fotbal_proiect.service.MatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matches")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }
}
