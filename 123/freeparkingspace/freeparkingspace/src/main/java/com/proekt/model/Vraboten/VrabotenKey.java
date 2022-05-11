package com.proekt.model.Vraboten;

import com.proekt.model.Najava;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class VrabotenKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="korisnicko_ime")
    public Najava user;

    public VrabotenKey(Najava user) {
        this.user = user;
    }

    public VrabotenKey() {

    }

    public Najava getUser() {
        return user;
    }

    public void setUser(Najava user) {
        this.user = user;
    }
}
