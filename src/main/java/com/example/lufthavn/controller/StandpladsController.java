package com.example.lufthavn.controller;

import com.example.lufthavn.model.Airport;
import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.model.Standplads;
import com.example.lufthavn.service.StandpladsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StandpladsController {

    @Autowired
    private StandpladsService service;

    @RequestMapping("/standpladslist")
    public String viewStandpladsPage(Model model, @Param("keyword") String keyword){
        List<Standplads> standpladsList = service.listAll(keyword);
        model.addAttribute("standpladslist", standpladsList);
        model.addAttribute("keyword", keyword);
        return "standpladslist";
    }


    @PostMapping("/savestandplads")
    public String saveStandplads(@ModelAttribute ("standplads") Standplads standplads){
        service.save(standplads);
        return "redirect:/standpladslist";
    }

    @GetMapping("/editstandplads{id}")
    public String updateSPForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("standplads", service.findById(id));
        return "editstandplads";
    }
}
