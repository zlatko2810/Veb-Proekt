package com.proekt.Controller;


import com.proekt.Repository.NajavaRepository;
import com.proekt.Repository.VrabotenRepository1;
import com.proekt.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class Employee {

    private final VrabotenRepository1 vrabotenRepository1;
    private final NajavaRepository najavaRepository;
    private final EmployeeService employeeService;

    public Employee(VrabotenRepository1 vrabotenRepository1, NajavaRepository najavaRepository, EmployeeService employeeService) {
        this.vrabotenRepository1 = vrabotenRepository1;
        this.najavaRepository = najavaRepository;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getMoviePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("employee", this.vrabotenRepository1.findAll());
        model.addAttribute("bodyContent", "employee");
        return "master-template";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        this.employeeService.delete(id);
        return "redirect:/employee";
    }
}
