package com.proekt.model;
import com.proekt.model.Vraboten.Vraboten;
import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Kancelar{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int idKancelar;

    public Kancelar(int idKancelar) {
        this.idKancelar = idKancelar;
    }

    public Kancelar() {
    }
}