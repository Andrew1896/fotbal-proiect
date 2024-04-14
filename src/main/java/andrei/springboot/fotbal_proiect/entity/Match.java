package andrei.springboot.fotbal_proiect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
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

    public Match(LocalDateTime date, String location, String score) {
        this.date = date;
        this.location = location;
        this.score = score;
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
