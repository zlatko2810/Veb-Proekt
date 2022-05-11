package com.proekt.model.Vraboten;
import lombok.Data;

import javax.persistence.*;
@Data
@Table
@Entity
public class Vraboten{

    private int idVraboten;

    @Column(name = "uloga")
    private String uloga;

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private VrabotenKey vrabotenKey;


    public Vraboten() {
    }

    public Vraboten(int idVraboten, String uloga, VrabotenKey vrabotenKey) {
        this.vrabotenKey = vrabotenKey;
        this.idVraboten = idVraboten;
        this.uloga = uloga;
    }

    public VrabotenKey getVrabotenKey() {
        return vrabotenKey;
    }

    public void setVrabotenKey(VrabotenKey vrabotenKey) {
        this.vrabotenKey = vrabotenKey;
    }

    public int getIdVraboten() {
        return idVraboten;
    }

    public void setIdVraboten(int idVraboten) {
        this.idVraboten = idVraboten;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}