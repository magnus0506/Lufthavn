package com.example.lufthavn.controller;

import com.example.lufthavn.model.Airport;
import com.example.lufthavn.service.AirportService;
import com.example.lufthavn.service.dateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AirportController {
    @Autowired
    private AirportService service;

    @GetMapping("/airports")
    public String viewAirPortPage(Model model) {
        return listByPage(model,1);
    }
    @GetMapping("/airportpage/{pageNumber}")
    public String listByPage(Model model, @PathVariable("pageNumber") int currentPage){
        Page<Airport> page = service.listAll(currentPage);
        long totalAirports = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Airport> listAirports = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalAirports", totalAirports);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listAirports", listAirports);
        return "airports";
    }

    @GetMapping("/calc")
    @ResponseBody
    public String date(@RequestParam int year, int month, int day){

        dateService dateService = new dateService();

        return "" + dateService.calcDate(year,month,day);
    }

}
