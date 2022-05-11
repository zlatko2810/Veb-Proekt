package com.proekt.Controller;

import com.proekt.Repository.*;
import com.proekt.model.Avtomobil;
import com.proekt.model.Korisnik.Korisnik;
import com.proekt.model.Korisnik.KorisnikKey;
import com.proekt.model.Plakjanje;
import com.proekt.model.Rezervacija;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class Reservation {

    private final RezervacijaRepository rezervacijaRepository;
    private final KorisnikRepository korisnikRepository;
    private final PlakjanjeRepository plakjanjeRepository;
    private final NajavaRepository najavaRepository;
    private final ParkingMestoRepository parkingMestoRepository;
    private final AvtomobilRepository avtomobilRepository;

    public Reservation(RezervacijaRepository rezervacijaRepository, KorisnikRepository korisnikRepository, PlakjanjeRepository plakjanjeRepository, NajavaRepository najavaRepository, ParkingMestoRepository parkingMestoRepository, AvtomobilRepository avtomobilRepository) {
        this.rezervacijaRepository = rezervacijaRepository;
        this.korisnikRepository = korisnikRepository;
        this.plakjanjeRepository = plakjanjeRepository;
        this.najavaRepository = najavaRepository;
        this.parkingMestoRepository = parkingMestoRepository;
        this.avtomobilRepository = avtomobilRepository;
    }

    @RequestMapping("/parking-place")
    public String getRegisterPage(@RequestParam(value = "broj_na_pmesta", required = false) Integer broj_na_pmesta, Model model) {

        model.addAttribute("parking", this.parkingMestoRepository.findById(broj_na_pmesta).get());
        model.addAttribute("bodyContent","reservation");
        return "master-template";
    }

    @PostMapping("/parking-place/add")
    public String register(@RequestParam String reg_tablica,
                           @RequestParam String marka,
                           @RequestParam String boja,
                           @RequestParam String pocetno_vreme,
                           @RequestParam String krajno_vreme,
                           @RequestParam Integer broj_na_pmesta

    ) {

       // LocalDateTime dateTime = LocalDateTime.parse(pocetno_vreme);
       // LocalDateTime dateTime2 = LocalDateTime.parse(krajno_vreme);
        KorisnikKey korisnikKey = new KorisnikKey();
        korisnikKey.setUser(this.najavaRepository.findById("Majkl0810").get());
        Korisnik korisnik = korisnikRepository.findById(korisnikKey).get();

        Avtomobil avtomobil = new Avtomobil();
        avtomobil.setRegTablica(reg_tablica);
        avtomobil.setKorisnickoIme(korisnik);
        avtomobil.setBoja(boja);
        avtomobil.setMarka(marka);
        this.avtomobilRepository.save(avtomobil);

        Rezervacija rezervacija = new Rezervacija();

        List<Rezervacija> rezervacijaList = this.rezervacijaRepository.findAll();
        int sizeRezervacija = rezervacijaList.size() + 1;
        rezervacija.setIdRezervacija(sizeRezervacija);

        rezervacija.setRegTablica(avtomobil);
        //rezervacija.setPocetnoVreme(dateTime);
        //rezervacija.setKrajnoVreme(dateTime2);
        rezervacija.setBrojNaPmesta(this.parkingMestoRepository.findById(broj_na_pmesta).get());
        Plakjanje plakjanje = plakjanjeRepository.findById(113).get();
        rezervacija.setIdPlakanje(plakjanje);
        this.rezervacijaRepository.save(rezervacija);
        return "redirect:/success";
    }




}
