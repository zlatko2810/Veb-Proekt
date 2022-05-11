package com.proekt.model.Korisnik;

import com.proekt.model.Najava;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class KorisnikKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="korisnicko_ime")
    public Najava user;

    public KorisnikKey(Najava user) {
        this.user = user;
    }

    public KorisnikKey() {

    }

    public Najava getUser() {
        return user;
    }

    public void setUser(Najava user) {
        this.user = user;
    }
}
