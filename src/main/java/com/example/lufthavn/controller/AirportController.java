package com.example.lufthavn.controller;

import com.example.lufthavn.model.Airport;
import com.example.lufthavn.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class AirportController {
    @Autowired
    private AirportService service;

    @GetMapping("/airports")
    public String viewAirPortPage(Model model) {
        Iterable<Airport> listAirports = service.listAll();
        model.addAttribute("listAirport", listAirports);
        return "airports";
    }

}
