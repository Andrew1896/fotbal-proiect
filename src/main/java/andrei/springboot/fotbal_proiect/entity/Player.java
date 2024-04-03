package andrei.springboot.fotbal_proiect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "team_name")
    private String team;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teams_id")
//    private Team teamName;
    // TODO: 03.04.2024 Inceputul e bun. Relatia dintre Player si Team nu este @OneToOne, mai multi jucatori pot juca intr-o echipa, respectiv este ManyToOne.
    // TODO: 03.04.2024 Many players in one team !! 

    public Player() {
    }

    public Player(String name, String surname, String position, String team) {
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
