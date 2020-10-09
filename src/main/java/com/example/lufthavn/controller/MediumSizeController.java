package com.example.lufthavn.controller;

import com.example.lufthavn.model.MediumSize;
import com.example.lufthavn.service.MediumSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MediumSizeController {
    @Autowired
    private MediumSizeService service;

    @GetMapping("/statuslistmedium")
    public String viewStandardPage(Model model, @Param("keyword") String keyword){
        List<MediumSize> mediumSizeList = service.listAll(keyword);
        model.addAttribute("mediumsizelist", mediumSizeList);
        return "statuslistmedium";
    }
}
