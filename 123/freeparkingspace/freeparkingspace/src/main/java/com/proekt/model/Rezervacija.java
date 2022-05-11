package com.proekt.model;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table
@Entity

public class Rezervacija {
    @Id
    @Column(name = "id_rezervacija")
    private int idRezervacija;
    private LocalDateTime pocetnoVreme;
    private LocalDateTime krajnoVreme;

    @ManyToOne
    @JoinColumn(name="reg_tablica")
    public Avtomobil regTablica;

    @OneToOne
    @JoinColumn(name="broj_na_pmesta")
    private ParkingMesto brojNaPmesta;

    @OneToOne
    @JoinColumn(name="id_plakanje")
    private Plakjanje idPlakanje;

    public Rezervacija() {
    }

    public Rezervacija(int idRezervacija, LocalDateTime pocetnoVreme, LocalDateTime krajnoVreme, Avtomobil regTablica, ParkingMesto brojNaPmesta, Plakjanje idPlakanje) {
        this.idRezervacija = idRezervacija;
        this.pocetnoVreme = pocetnoVreme;
        this.krajnoVreme = krajnoVreme;
        this.regTablica = regTablica;
        this.brojNaPmesta = brojNaPmesta;
        this.idPlakanje = idPlakanje;
    }

    public int getIdRezervacija() {
        return idRezervacija;
    }

    public void setIdRezervacija(int idRezervacija) {
        this.idRezervacija = idRezervacija;
    }

    public LocalDateTime getPocetnoVreme() {
        return pocetnoVreme;
    }

    public void setPocetnoVreme(LocalDateTime pocetnoVreme) {
        this.pocetnoVreme = pocetnoVreme;
    }

    public LocalDateTime getKrajnoVreme() {
        return krajnoVreme;
    }

    public void setKrajnoVreme(LocalDateTime krajnoVreme) {
        this.krajnoVreme = krajnoVreme;
    }

    public Avtomobil getRegTablica() {
        return regTablica;
    }

    public void setRegTablica(Avtomobil regTablica) {
        this.regTablica = regTablica;
    }

    public ParkingMesto getBrojNaPmesta() {
        return brojNaPmesta;
    }

    public void setBrojNaPmesta(ParkingMesto brojNaPmesta) {
        this.brojNaPmesta = brojNaPmesta;
    }

    public Plakjanje getIdPlakanje() {
        return idPlakanje;
    }

    public void setIdPlakanje(Plakjanje idPlakanje) {
        this.idPlakanje = idPlakanje;
    }
}