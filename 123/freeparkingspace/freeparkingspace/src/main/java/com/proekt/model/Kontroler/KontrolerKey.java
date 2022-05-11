package com.proekt.model.Kontroler;

import com.proekt.model.Najava;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class KontrolerKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="korisnicko_ime")
    public Najava user;

    public KontrolerKey(Najava user) {
        this.user = user;
    }

    public KontrolerKey() {

    }

    public Najava getUser() {
        return user;
    }

    public void setUser(Najava user) {
        this.user = user;
    }
}
