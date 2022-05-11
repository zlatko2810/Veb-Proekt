package com.proekt.model.Kontroler;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Kontroler{

    private int id_kontroler;

    @EmbeddedId
    private KontrolerKey kontrolerKey;

    public Kontroler(int id_kontroler, KontrolerKey kontrolerKey) {
        this.id_kontroler = id_kontroler;
        this.kontrolerKey = kontrolerKey;
    }

    public Kontroler() {

    }

    public int getId_kontroler() {
        return id_kontroler;
    }

    public void setId_kontroler(int id_kontroler) {
        this.id_kontroler = id_kontroler;
    }

    public KontrolerKey getKontrolerKey() {
        return kontrolerKey;
    }

    public void setKontrolerKey(KontrolerKey kontrolerKey) {
        this.kontrolerKey = kontrolerKey;
    }
}