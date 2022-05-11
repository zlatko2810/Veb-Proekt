package com.proekt.model;
import com.proekt.model.Korisnik.Korisnik;
import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Data
@Table
@Entity
public class Kazna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private int idKazna;
    @Column(nullable = false,unique = true)
    private int iznos;
    @Column(nullable = false,unique = true)
    private int brojKazni;
    @ManyToOne
    @JoinColumn(name="korisnickoime")
    public Korisnik korisnickoIme;

    public Kazna() {
    }

    public Kazna(int idKazna, int iznos, int brojKazni) {
        this.idKazna = idKazna;
        this.iznos = iznos;
        this.brojKazni = brojKazni;
    }
}