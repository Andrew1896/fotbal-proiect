package andrei.springboot.fotbal_proiect.dto.rest.match;

import andrei.springboot.fotbal_proiect.entity.Match;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class CreateMatchRequest { // Data Transfer Object
    private String teamA;
    private String teamB;
    private LocalDateTime date;
    private String location;
    private String score;

    public Match toEntity() {
        Match match = new Match();

        match.setTeamA(this.teamA);
        match.setTeamB(this.teamB);
        match.setDate(this.date);
        match.setLocation(this.location);
        match.setScore(this.score);

        return match;
    }
}
