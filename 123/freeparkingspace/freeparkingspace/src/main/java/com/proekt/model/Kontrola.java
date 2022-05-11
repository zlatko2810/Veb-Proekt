package com.proekt.model;

import com.proekt.model.Kontroler.Kontroler;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.ManyToOne;
@Data
@Table
@Entity
public class Kontrola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int idKontrola;

    @Column(nullable = false, unique = true)
    private int izvrsenaKontrola;

    @Column(nullable = false, unique = true)
    private LocalDateTime vremeNaKontrola;

    @Column(nullable = false,length = 300)
    private String konstantacija;

    @ManyToOne
    @JoinColumn(name="korisnicko_ime")
    public Kontroler korisnickoIme;

    @ManyToOne
    @JoinColumn(name="broj_na_pmesta")
    public ParkingMesto brojNaPmesta;

    @ManyToOne
    @JoinColumn(name="id_rezervacija")
    public Rezervacija idRezervacija;

    @ManyToOne
    @JoinColumn(name="id_kazna")
    public Kazna idKazna;

    public Kontrola() {
    }

    public Kontrola(int idKontrola, int izvrsenaKontrola, LocalDateTime vremeNaKontrola, String konstantacija) {
        this.idKontrola = idKontrola;
        this.izvrsenaKontrola = izvrsenaKontrola;
        this.vremeNaKontrola = vremeNaKontrola;
        this.konstantacija = konstantacija;
    }
}