package com.proekt.model.Korisnik;
import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "korisnik")
@Entity
public class Korisnik{

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private KorisnikKey korisnikKey;

    @Column(name = "id_korisnik")
    private int korisnicko_ime;

    public Korisnik(KorisnikKey korisnikKey, int korisnicko_ime) {
        this.korisnikKey = korisnikKey;
        this.korisnicko_ime = korisnicko_ime;
    }

    public Korisnik() {

    }

    public KorisnikKey getKorisnikKey() {
        return korisnikKey;
    }

    public void setKorisnikKey(KorisnikKey korisnikKey) {
        this.korisnikKey = korisnikKey;
    }

    public int getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(int korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }
}