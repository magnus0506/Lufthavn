package com.example.lufthavn.controller;

import com.example.lufthavn.model.Airport;
import com.example.lufthavn.model.Standplads;
import com.example.lufthavn.service.StandpladsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StandpladsController {

    @Autowired
    private StandpladsService service;

//    @GetMapping("/standpladslist")
//    public String viewStandpladsPage(Model model){
//        Iterable<Standplads> standpladsList = service.listAll();
//        model.addAttribute("standpladslist", standpladsList);
//        return "standpladslist";
//    }

//    @PostMapping("/save")
//    public String saveAirport(@ModelAttribute ("airport")Airport airport){
//
//    }
}
