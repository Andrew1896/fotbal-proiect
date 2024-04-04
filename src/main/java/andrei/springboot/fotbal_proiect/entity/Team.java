package andrei.springboot.fotbal_proiect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "founded")
    private Integer founded;
    @Column(name = "stadium")
    private String stadium;
    // TODO: 03.04.2024 Aici lipseste legatura cu clasa Player trebuie sa adaugi adnotatia care lipseste
//    private List<Player> players;

    public Team() {
    }
//    public List<Player> getPlayers() {
//        return players;
//    }

    public Team(String name, Integer founded, String stadium) {
        this.name = name;
        this.founded = founded;
        this.stadium = stadium;
//        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

//    public void setPlayers(List<Player> players) {
//        this.players = players;
//    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", founded=" + founded +
                ", stadium='" + stadium + '\'' +
                '}';
    }
}
