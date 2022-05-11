package com.proekt.model;
import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import com.proekt.model.Admin.Administrator;
@Data
@Table
@Entity

public class ImeNaParking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int Id_ime;

    @Column(nullable = false,length = 150,unique = true)
    private String Lokacija;

    @ManyToOne
    @JoinColumn(name="administrator_korisnicko_ime")
    public Administrator korisnickoime;

    public ImeNaParking(int id_ime, String lokacija) {
        Id_ime = id_ime;
        Lokacija = lokacija;
    }

    public ImeNaParking() {
    }

    public int getId_ime() {
        return Id_ime;
    }

    public void setId_ime(int id_ime) {
        Id_ime = id_ime;
    }

    public String getLokacija() {
        return Lokacija;
    }

    public void setLokacija(String lokacija) {
        Lokacija = lokacija;
    }

    public Administrator getKorisnickoime() {
        return korisnickoime;
    }

    public void setKorisnickoime(Administrator korisnickoime) {
        this.korisnickoime = korisnickoime;
    }
}