package com.example.lufthavn.controller;

import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.service.ArrDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ArrDepController {

    @Autowired
    private ArrDepService service;

    @GetMapping("/arrdeplist")
    public String viewArrDepPage(Model model) {
    return listByPage(model,1);
    }

    @GetMapping("/arrdeppage/{pageNumber}")
    public String listByPage(Model model, @PathVariable("pageNumber") int currentPage){
                Page<ArrDep> page = service.listAll(currentPage);
        long totalArrDeps = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<ArrDep> listArrDep = page.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalArrDeps", totalArrDeps);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("listArrDep", listArrDep);
        return "arrdeplist";
    }
    @GetMapping("/arrdepnew")
    public String showNewArrDepForm(Map<String, Object> model) {
        model.put("arrdep", new ArrDep());
        return "arrdepnew";
    }

    @PostMapping("/arrdepsave")
    public String saveArrDep(@ModelAttribute ("arrdep") ArrDep arrDep) {
        service.save(arrDep);
        return "redirect:/arrdeplist";
    }

    @GetMapping("/arrdepedit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("arrdep",service.findById(id));
        return "arrdepedit";
    }

}
