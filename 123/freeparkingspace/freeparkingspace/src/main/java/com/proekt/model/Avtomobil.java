package com.proekt.model;


import com.proekt.model.Korisnik.Korisnik;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Data
@Table
@Entity

public class Avtomobil {

    @Id
    @Column(name="reg_tablica")
    private String regTablica;

    @Column(nullable = false,length = 20,unique = true)
    private String marka;

    @Column(nullable = false,length = 15,unique = true)
    private String boja;



    @ManyToOne
    @JoinColumn(name="korisnickoime")
    public Korisnik korisnickoIme;

    public Avtomobil(String regTablica, String marka, String boja, Korisnik korisnik) {
        this.regTablica = regTablica;
        this.korisnickoIme = korisnik;
        this.marka = marka;
        this.boja = boja;
    }

    public Avtomobil() {
    }

    public String getRegTablica() {
        return regTablica;
    }

    public void setRegTablica(String regTablica) {
        this.regTablica = regTablica;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public Korisnik getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(Korisnik korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
}