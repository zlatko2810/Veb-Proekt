package com.proekt.model;
import com.proekt.model.Korisnik.Korisnik;
import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Data
@Table
@Entity

public class Plakjanje {

    @Id
    @Column(nullable = false, unique = true)
    private int idPlakanje;

    @Column(nullable = false,length = 30,unique = true)
    private  String brTel;

    @Column(nullable = false,length = 150,unique = true)
    private  String brNaSmetka;

    @Column(nullable = false,length = 150,unique = true)
    private  String tipPlakjanje;
    @ManyToOne
    @JoinColumn(name="korisnickoime")
    public Korisnik korisnickoIme;

    public Plakjanje() {
    }

    public Plakjanje(int idPlakanje, String brTel, String brNaSmetka, String tipPlakjanje) {
        this.idPlakanje = idPlakanje;
        this.brTel = brTel;
        this.brNaSmetka = brNaSmetka;
        this.tipPlakjanje = tipPlakjanje;
    }
}