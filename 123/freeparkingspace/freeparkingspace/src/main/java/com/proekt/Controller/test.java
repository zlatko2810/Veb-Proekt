package com.proekt.Controller;

import com.proekt.Repository.*;
import com.proekt.model.*;
import com.proekt.model.Korisnik.Korisnik;
import com.proekt.model.Korisnik.KorisnikKey;
import com.proekt.model.Vraboten.Vraboten;
import com.proekt.model.Vraboten.VrabotenKey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class test {

    private final NajavaRepository najavaRepository;
    private final KorisnikRepository korisnikRepository;
    private final VrabotenRepository1 vrabotenRepository;
    private final AvtomobilRepository avtomobilRepository;
    private final ParkingMestoRepository parkingMestoRepository;
    private final PlakjanjeRepository plakjanjeRepository;


    public test(NajavaRepository najavaRepository, KorisnikRepository korisnikRepository, VrabotenRepository1 vrabotenRepository, AvtomobilRepository avtomobilRepository, ParkingMestoRepository parkingMestoRepository, PlakjanjeRepository plakjanje, PlakjanjeRepository plakjanjeRepository) {
        this.najavaRepository = najavaRepository;
        this.korisnikRepository = korisnikRepository;
        this.vrabotenRepository = vrabotenRepository;
        this.avtomobilRepository = avtomobilRepository;
        this.parkingMestoRepository = parkingMestoRepository;
        this.plakjanjeRepository = plakjanjeRepository;
    }


    @GetMapping
    public ResponseEntity viewQuery() {
        Najava najava = new Najava();
        najava.setKorisnickoIme("korisnicko_ime");
        najava.setIme("ime");
        najava.setPrezime("prezime");
        najava.setEmbg("embg");
        najava.setEmail("email");
        najava.setBrTel("br_tel");
        najava.setPassword("password");



        //////TEST-RESERVATION-ALL///////
        Avtomobil avtomobil = avtomobilRepository.findById("SK-2410-AZ").get();
        ParkingMesto parkingMesto = parkingMestoRepository.findById(1).get();
        Plakjanje plakjanje = plakjanjeRepository.findById(113).get();
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setIdRezervacija(1337);
        rezervacija.setRegTablica(avtomobil);
        rezervacija.setBrojNaPmesta(parkingMesto);
        rezervacija.setIdPlakanje(plakjanje);

        return ResponseEntity.ok(rezervacija);


    }



}
