package andrei.springboot.fotbal_proiect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    // TODO: 28.03.2024 ID-ul trebuie sa fie Long nu long
    private long id;
    // TODO: 28.03.2024 Numele echipei trebuie sa fie UNIC la nivel de baza de date si nu poate sa fie null
    // TODO: 28.03.2024 Configureaza asta aici in adnotarea @Column sa nu putem seta null si sa fie unique
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "founded")
    private int founded; // TODO: 28.03.2024 Intreaba pe CHAT-GPT:  De ce in cazul asta: @Column(name = "founded") private int founded;  e mai bine sa folosim Integer in loc de int ?
    @Column(name = "stadium")
    private String stadium;

    public Team() {
    }

    public Team(String name, int founded, String stadium) {
        this.name = name;
        this.founded = founded;
        this.stadium = stadium;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

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
