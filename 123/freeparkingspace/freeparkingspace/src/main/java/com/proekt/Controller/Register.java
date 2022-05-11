package com.proekt.Controller;

import com.proekt.Repository.KorisnikRepository;
import com.proekt.Repository.NajavaRepository;
import com.proekt.model.Korisnik.Korisnik;
import com.proekt.model.Korisnik.KorisnikKey;
import com.proekt.model.Najava;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/register")
public class Register {

    private final NajavaRepository najavaRepository;
    private final KorisnikRepository korisnikRepository;

    public Register(NajavaRepository najavaRepository, KorisnikRepository korisnikRepository) {
        this.najavaRepository = najavaRepository;
        this.korisnikRepository = korisnikRepository;
    }


    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent","register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String korisnicko_ime,
                           @RequestParam String ime,
                           @RequestParam String prezime,
                           @RequestParam String embg,
                           @RequestParam String email,
                           @RequestParam String br_tel,
                           @RequestParam String password
    ) {
        Najava najava = new Najava();
        najava.setKorisnickoIme(korisnicko_ime);
        najava.setIme(ime);
        najava.setPrezime(prezime);
        najava.setEmbg(embg);
        najava.setEmail(email);
        najava.setBrTel(br_tel);
        najava.setPassword(password);

        KorisnikKey korisnikKey = new KorisnikKey(najava);
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnikKey(korisnikKey);
        List<Korisnik> korisnik1 = korisnikRepository.findAll();
        int id = korisnik1.size() + 1;
        korisnik.setKorisnicko_ime(id);

        this.najavaRepository.save(najava);
        this.korisnikRepository.save(korisnik);
        return "redirect:/success";
    }
}
