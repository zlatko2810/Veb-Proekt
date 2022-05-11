package com.proekt.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Blank {


    @GetMapping("/contact")
    public String getViewHome(Model model) {

        model.addAttribute("bodyContent","contact");
        return "master-template";
    }
    @GetMapping("/about")
    public String getViewHome2(Model model) {

        model.addAttribute("bodyContent","about");
        return "master-template";
    }

}
