package com.example.lufthavn.controller;


import com.example.lufthavn.model.Standplads;
import com.example.lufthavn.service.StandpladsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StandpladsController {

    @Autowired
    private StandpladsService service;

    @GetMapping("/standpladslist")
    public String viewStandpladsPage(Model model, @Param("keyword") String keyword){
        List<Standplads> standpladsList = service.listAll(keyword);
        model.addAttribute("standpladslist", standpladsList);
        return "standpladslist";
    }

    @GetMapping("/standpladssearch")
    public String viewStandpladsSearch(Model model, @Param("keyword") String keyword){
        List<Standplads> standpladsList = service.find(keyword);
        model.addAttribute("standpladslist", standpladsList);
        model.addAttribute("keyword", keyword);
        return "standpladssearch";
    }


    @PostMapping("/standpladssave")
    public String saveStandplads(@ModelAttribute ("standplads") Standplads standplads){
        service.save(standplads);
        return "redirect:/standpladslist";
    }

    @GetMapping("/standpladsedit/{id}")
    public String updateSPForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("standplads", service.findById(id));
        return "standpladsedit";
    }

}
