package com.proekt.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/success")
public class SuccessController {
    @GetMapping
    public String getViewHome(Model model) {
        model.addAttribute("bodyContent","success");
        return "master-template";
    }
}
