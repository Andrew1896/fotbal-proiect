package andrei.springboot.fotbal_proiect.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "teamA")
    private String teamA;
    @Column(name = "teamB")
    private String teamB;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "location")
    private String location;
    @Column(name = "score")
    private String score;

    public Match() {
    }

    public Match(LocalDateTime date, String location, String score) {
        this.date = date;
        this.location = location;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id)
               && Objects.equals(teamA, match.teamA)
               && Objects.equals(teamB, match.teamB)
               && Objects.equals(date, match.date)
               && Objects.equals(location, match.location)
               && Objects.equals(score, match.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamA, teamB, date, location, score);
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
