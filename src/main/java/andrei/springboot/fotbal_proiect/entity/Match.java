package andrei.springboot.fotbal_proiect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "location")
    private String location;
    @Column(name = "score")
    private String score;

    public Match() {
    }

    public Match(String date, String location, String score) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
