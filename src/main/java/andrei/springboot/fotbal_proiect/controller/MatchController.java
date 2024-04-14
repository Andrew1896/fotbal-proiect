package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchRequest;
import andrei.springboot.fotbal_proiect.dto.rest.match.CreateMatchResponse;
import andrei.springboot.fotbal_proiect.dto.rest.match.GetAllMatchesResponse;
import andrei.springboot.fotbal_proiect.entity.Match;
import andrei.springboot.fotbal_proiect.service.MatchService;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public CreateMatchResponse createMatch(@RequestBody CreateMatchRequest request) {
        return matchService.createMatch(request);
    }

    @GetMapping
    public List<GetAllMatchesResponse> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @GetMapping("/upcoming")
    public List<UpcomingMatches> getAllUpcomingMatches() {
        return matchService.getAllUpcomingMatches()
                .stream()
                .map(UpcomingMatches::fromEntity)
                .toList();
    }

    public static class UpcomingMatches {
        private Long id;
        private String teamA;
        private String teamB;
        private LocalDateTime date;
        private String location;

        public UpcomingMatches() {
        }

        private UpcomingMatches(Long id, String teamA, String teamB, LocalDateTime date, String location) {
            this.id = id;
            this.teamA = teamA;
            this.teamB = teamB;
            this.date = date;
            this.location = location;
        }

        public static UpcomingMatches fromEntity(Match match) {
            return new UpcomingMatches(match.getId(), match.getTeamA(), match.getTeamB(), match.getDate(), match.getLocation());
        }

        public Long getId() {
            return id;
        }

        public String getTeamA() {
            return teamA;
        }

        public String getTeamB() {
            return teamB;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public String getLocation() {
            return location;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UpcomingMatches that = (UpcomingMatches) o;
            return Objects.equals(id, that.id) && Objects.equals(teamA, that.teamA) && Objects.equals(teamB, that.teamB) && Objects.equals(date, that.date) && Objects.equals(location, that.location);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, teamA, teamB, date, location);
        }
    }
}
