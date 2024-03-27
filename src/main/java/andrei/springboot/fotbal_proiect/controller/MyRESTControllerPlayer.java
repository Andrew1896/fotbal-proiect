package andrei.springboot.fotbal_proiect.controller;

import andrei.springboot.fotbal_proiect.entity.Player;
import andrei.springboot.fotbal_proiect.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api") // TODO: 27.03.2024 Incicat sa adaugi o versie a acestui api si domeniul cu care lucreaza. Exemplu: '/api/v1/players'
public class MyRESTControllerPlayer { // TODO: 27.03.2024 Controller trebuie sa fie la final, denumire alternative : 'PlayerController'

    @Autowired
    private PlayerService playerService; // TODO: 27.03.2024 E de indicata injectarea prin constructor in loc de  @Autowired

    @GetMapping("/players") // TODO: 27.03.2024 Intr-ucat ai adaugat /players in  @RequestMapping, nu mai trebuie folosit deasupra metodelor
    public List<Player> showAllPlayers() {
        List<Player> allPlayers = playerService.getAllPlayers(); // TODO: 27.03.2024 Se poate de dacut intr-o singura linie
        return allPlayers;
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        Player player = playerService.getPlayer(id); // TODO: 27.03.2024 Se poate de dacut intr-o singura linie
        return player;
    }

    @PostMapping("/players")
    public Player addNewPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player; // TODO: 27.03.2024 Este o practica rea sa returnezi din functie parametrii functiei. Rreturneaza void mai bine
    }

    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player; // TODO: 27.03.2024 Este o practica rea sa returnezi din functie parametrii functiei. Rreturneaza void mai bine
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable int id) {
        Player player = playerService.getPlayer(id); // TODO: 27.03.2024 Request in baza inutil, player nu se foloseste nicaieri
        playerService.deletePlayer(id);
        return "Player with ID = " + id + " was deleted.";
    }

//    @GetMapping("/teams/name/players}")
//    public List<Player> showAllPlayersBySpecificTeam(@PathVariable String name) {
//        List<Player> players = playerService.findAllByName(name);
//        return players;
//    }
}
