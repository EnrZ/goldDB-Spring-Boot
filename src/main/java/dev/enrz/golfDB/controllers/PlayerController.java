package dev.enrz.golfDB.controllers;

import dev.enrz.golfDB.data.PlayerRepository;
import dev.enrz.golfDB.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping("addplayer")
    public String renderAddPlayerForm(Model model){

        //the empty event object just made will have information about the fields
        model.addAttribute("player" , new Player());

        return "players/addplayer";

    }

    @PostMapping("addplayer")
    public String addPlayerForm(@ModelAttribute @Valid Player newPlayer, Errors errors, Model model)  {

        //the empty event object just made will have information about the fields
        model.addAttribute("player", new Player());


        playerRepository.save(newPlayer);

        return "players/addplayer";
    }


    @GetMapping
    public String displayPlayers(@RequestParam(required = false) Integer categoryId, Model model) {

        if (categoryId == null) {
            model.addAttribute("players", playerRepository.findAll());
            model.addAttribute("title", "All Players");
        }


        return "players/index";
    }

}

