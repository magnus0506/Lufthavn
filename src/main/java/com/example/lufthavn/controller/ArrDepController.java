package com.example.lufthavn.controller;

import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.service.ArrDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class ArrDepController {

    @Autowired
    private ArrDepService service;

    @GetMapping("/arrdeplist")
    public String viewArrDepPage(Model model) {
        Iterable<ArrDep> listArrDep = service.listAll();
        model.addAttribute("listArrDep", listArrDep);
        return "arrdeplist";
    }

    @GetMapping("/new")
    public String showNewArrDepForm(Map<String, Object> model) {
        model.put("arrdep", new ArrDep());
        return "new_arrdep";
    }

    @PostMapping("/save")
    public String saveArrDep(@ModelAttribute ("arrdep") ArrDep arrDep) {
        service.save(arrDep);
        return "redirect:/arrdeplist";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("arrdep",service.findById(id));
        return "edit_arrdep";
    }
}
