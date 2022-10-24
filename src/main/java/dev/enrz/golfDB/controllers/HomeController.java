package dev.enrz.golfDB.controllers;

import dev.enrz.golfDB.data.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index() {
        return "index";
    }

}
