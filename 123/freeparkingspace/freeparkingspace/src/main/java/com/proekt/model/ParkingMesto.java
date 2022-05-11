package com.proekt.model;
import lombok.Data;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Data
@Table(name = "parking_mesto")
@Entity
public class ParkingMesto {


    @Id
    @Column(nullable = false, unique = true)
    private int brojNaPmesta;

    @ManyToOne
    @JoinColumn(name="idzona")
    public Zona idZona;

    public ParkingMesto(int brojNaPmesta, Zona idZona) {
        this.brojNaPmesta = brojNaPmesta;
        this.idZona = idZona;
    }

    public ParkingMesto() {
    }

    public int getBrojNaPmesta() {
        return brojNaPmesta;
    }

    public void setBrojNaPmesta(int brojNaPmesta) {
        this.brojNaPmesta = brojNaPmesta;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

}