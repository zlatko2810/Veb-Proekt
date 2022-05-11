package com.proekt.model;

import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Data
@Table(name = "zona")
@Entity
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private String idZona;
    @ManyToOne
    @JoinColumn(name="ime_na_parking_id_ime")
    public ImeNaParking idIme;

    public Zona(String idZona, ImeNaParking idIme) {
        this.idZona = idZona;
        this.idIme = idIme;
    }


    public Zona() {
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public ImeNaParking getIdIme() {
        return idIme;
    }

    public void setIdIme(ImeNaParking idIme) {
        this.idIme = idIme;
    }
}
