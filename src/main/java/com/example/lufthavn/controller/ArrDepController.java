package com.example.lufthavn.controller;

import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.service.ArrDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArrDepController {

    @Autowired
    private ArrDepService service;

    @RequestMapping("/")
    public String viewArrDepPage(Model model){
        List<ArrDep> listArrDep = service.listAll();
        model.addAttribute("listArrDep", listArrDep);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewArrDepForm(Model model){
        ArrDep arrDep = new ArrDep();
        model.addAttribute("arrdep", arrDep);

        return "new_arrdep";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String SaveArrDep(@ModelAttribute("arrdep") ArrDep arrDep){
        service.save(arrDep);
        return "redirect:/";
    }

//    @RequestMapping("/edit/{id}")
//    public ModelAndView ShowEditArrDepForm(@PathVariable(name = "id") Long id){
//        ModelAndView mav = new ModelAndView("edit_arrdep");
//
//        ArrDep arrDep = service.get(id);
//        ("arrdep", arrDep);
//        return mav;
//    }

    // Den her metode opretter en ny entity i stedet for at update den valgte
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model){
        ArrDep arrDep = service.get(id);
        model.addAttribute("arrdep", arrDep);
        return "update_arrdep";
    }
}
