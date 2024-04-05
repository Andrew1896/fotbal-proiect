package andrei.springboot.fotbal_proiect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long teamId;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "team_name")
    private String team;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teams_id")
    private Team teamName;

    public Player() {
    }

    public Player(String surname, String name, String position, String team) {
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.team = team;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + teamId +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}

