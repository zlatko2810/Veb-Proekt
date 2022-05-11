package com.proekt.Controller;

import com.proekt.Repository.NajavaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register-info")
public class RegisterConfirmation {

        @GetMapping
        public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
            if(error != null && !error.isEmpty()) {
                model.addAttribute("hasError", true);
                model.addAttribute("error", error);
            }
            model.addAttribute("bodyContent","registerConfirmation");
            return "master-template";
        }
}
