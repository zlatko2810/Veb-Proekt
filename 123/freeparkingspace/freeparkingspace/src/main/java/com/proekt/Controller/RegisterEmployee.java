package com.proekt.Controller;


import com.proekt.model.Kontroler.Kontroler;
import com.proekt.model.Kontroler.KontrolerKey;
import com.proekt.Repository.AdministratorRepository;
import com.proekt.Repository.KontrolerRepository;
import com.proekt.Repository.NajavaRepository;
import com.proekt.Repository.VrabotenRepository1;
import com.proekt.model.Admin.AdminKey;
import com.proekt.model.Admin.Administrator;
import com.proekt.model.Najava;
import com.proekt.model.Vraboten.Vraboten;
import com.proekt.model.Vraboten.VrabotenKey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/register-employee")
public class RegisterEmployee {

    private final NajavaRepository najavaRepository;
    private final AdministratorRepository administratorRepository;
    private final VrabotenRepository1 vrabotenRepository;
    private final KontrolerRepository kontrolerRepository;

    public RegisterEmployee(NajavaRepository najavaRepository, AdministratorRepository administratorRepository, VrabotenRepository1 vrabotenRepository, KontrolerRepository kontrolerRepository) {
        this.najavaRepository = najavaRepository;
        this.administratorRepository = administratorRepository;
        this.vrabotenRepository = vrabotenRepository;
        this.kontrolerRepository = kontrolerRepository;
    }


    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent","registerEmployee");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String korisnicko_ime,
                           @RequestParam String ime,
                           @RequestParam String prezime,
                           @RequestParam String embg,
                           @RequestParam String email,
                           @RequestParam String br_tel,
                           @RequestParam String password,
                           @RequestParam String user_role
    ) {

            String admin = "ROLE_ADMIN";
            String controller = "ROLE_CONTROLLER";



            if(user_role.equals(admin)){
            Najava najava = new Najava();
            najava.setKorisnickoIme(korisnicko_ime);
            najava.setIme(ime);
            najava.setPrezime(prezime);
            najava.setEmbg(embg);
            najava.setEmail(email);
            najava.setBrTel(br_tel);
            najava.setPassword(password);
            this.najavaRepository.save(najava);

            Administrator admin2 = new Administrator();
            AdminKey adminKey = new AdminKey(najava);
            admin2.setAdminKey(adminKey);
            List<Najava> administrators = najavaRepository.findAll();
            int size = administrators.size() + 1;
            admin2.setIdAdministrator(size);
            this.administratorRepository.save(admin2);

                Vraboten vraboten = new Vraboten();
                VrabotenKey vrabotenKey = new VrabotenKey(najava);
                vraboten.setVrabotenKey(vrabotenKey);
                //vraboten.setIdVraboten(1337);
                vraboten.setUloga("Administrator");
                vraboten.setIdVraboten(size);
            this.vrabotenRepository.save(vraboten);
            return "redirect:/success";
            }else if(user_role.equals(controller)){

                Najava najava = new Najava();
                najava.setKorisnickoIme(korisnicko_ime);
                najava.setIme(ime);
                najava.setPrezime(prezime);
                najava.setEmbg(embg);
                najava.setEmail(email);
                najava.setBrTel(br_tel);
                najava.setPassword(password);
                this.najavaRepository.save(najava);

                KontrolerKey kontrolerKey = new KontrolerKey(najava);
                Kontroler kontroler = new Kontroler();
                kontroler.setKontrolerKey(kontrolerKey);
                List<Najava> administrators = najavaRepository.findAll();
                int size = administrators.size() + 1;
                kontroler.setId_kontroler(size);
                this.kontrolerRepository.save(kontroler);

                Vraboten vraboten = new Vraboten();
                VrabotenKey vrabotenKey = new VrabotenKey(najava);
                vraboten.setVrabotenKey(vrabotenKey);
                //vraboten.setIdVraboten(1337);
                vraboten.setUloga("Controller");
                vraboten.setIdVraboten(size);
                this.vrabotenRepository.save(vraboten);
                return "redirect:/success";
            }else{
                return "redirect:/register-employee";
            }
    }

}
