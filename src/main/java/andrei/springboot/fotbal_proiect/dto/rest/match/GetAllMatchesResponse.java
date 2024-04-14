package andrei.springboot.fotbal_proiect.dto.rest.match;

import andrei.springboot.fotbal_proiect.entity.Match;

import java.time.LocalDateTime;

public class GetAllMatchesResponse {
    private Long id;
    private String teamA;
    private String teamB;
    private LocalDateTime date;
    private String location;
    private String score;

    public GetAllMatchesResponse() {
    }

    private GetAllMatchesResponse(Long id, String teamA, String teamB, LocalDateTime date, String location, String score) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.location = location;
        this.score = score;
    }

    public static GetAllMatchesResponse fromEntity(Match match) {
        return new GetAllMatchesResponse(
                match.getId(),
                match.getTeamA(),
                match.getTeamB(),
                match.getDate(),
                match.getLocation(),
                match.getScore()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
