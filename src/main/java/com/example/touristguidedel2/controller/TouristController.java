package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService service;

    public TouristController(TouristService touristService) {
        this.service = touristService;
    }

    @GetMapping
    public String getAttractions(Model model) {
        ArrayList<TouristAttraction> attractions = service.getAttractions();
        model.addAttribute("attractions", attractions);
        return "showattractions";
    }

    @GetMapping("/{name}")
    public String findAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = service.findAttractionByName(name);

        if (attraction == null) {
            model.addAttribute("errorMessage", "The attraction " + name + " has not been found");
            return "error";
        }

        model.addAttribute("attraction", attraction);
        return "attraction";
    }



}
