package dev.enrz.golfDB.controllers;

import dev.enrz.golfDB.data.CourseRepository;
import dev.enrz.golfDB.data.PlayerRepository;
import dev.enrz.golfDB.data.RoundRepository;
import dev.enrz.golfDB.models.Player;
import dev.enrz.golfDB.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("rounds")
public class RoundController {
    @Autowired
    private RoundRepository roundRepository;

    //round has a many-to-one relationship with course
    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("addround")
    public String renderAddRoundForm(Model model){

        //the empty event object just made will have information about the fields
        model.addAttribute("round" , new Round());

        model.addAttribute("courses",courseRepository.findAll());

        return "rounds/addround";

    }

    @PostMapping("addround")
    public String addRoundForm(@ModelAttribute @Valid Round newRound, Errors errors, Model model)  {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Round");

            //without this, the course options disappear after validation error
            model.addAttribute("courses",courseRepository.findAll());

            return "rounds/addround";
        }
        roundRepository.save(newRound);

        return "redirect:";
    }


    @GetMapping
    public String displayRounds(@RequestParam(required = false) Integer roundId, Model model) {

        if (roundId == null) {
            model.addAttribute("rounds", roundRepository.findAll());
            model.addAttribute("title", "All Rounds");
        }


        return "rounds/index";
    }

    @GetMapping("info")
    public String displayRoundInformation(@RequestParam Integer roundId, Model model){

        Optional<Round> result = roundRepository.findById(roundId);

        if(result.isEmpty()){
            String template = String.format("Invalid Event ID  %s", roundId);
            model.addAttribute("title", template);
        } else {
            Round round = result.get();
            String template = String.format("Event ID  %s", roundId);
            model.addAttribute("title", template);

            model.addAttribute("round", round);
        }

        return "rounds/info";
    }
}
