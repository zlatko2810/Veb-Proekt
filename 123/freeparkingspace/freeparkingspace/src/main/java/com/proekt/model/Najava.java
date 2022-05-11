package com.proekt.model;
import lombok.Data;

import javax.persistence.*;

@Table(name = "najava")
@Data
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public class Najava {
    @Id
    @Column (nullable = false,unique = true, length = 150)
    private String korisnickoIme;

    @Column (nullable = false,unique = true, length = 13)
    private String embg;
    @Column (nullable = false,unique = true, length = 150)
    private String brTel;
    @Column (nullable = false,unique = true, length = 50)
    private String email;
    @Column (nullable = false,unique = true, length = 150)
    private String password;
    @Column (nullable = false,unique = true, length = 150)
    private String ime;
    @Column (nullable = false,unique = true, length = 150)
    private String prezime;

    public Najava() {
    }

    public Najava(String korisnickoIme, String embg, String brTel, String email, String password, String ime, String prezime) {
        this.korisnickoIme = korisnickoIme;
        this.embg = embg;
        this.brTel = brTel;
        this.email = email;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public String getBrTel() {
        return brTel;
    }

    public void setBrTel(String brTel) {
        this.brTel = brTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
