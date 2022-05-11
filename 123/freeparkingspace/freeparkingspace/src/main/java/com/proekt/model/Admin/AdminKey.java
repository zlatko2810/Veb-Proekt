package com.proekt.model.Admin;


import com.proekt.model.Najava;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AdminKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="korisnicko_ime")
    public Najava user;

    public AdminKey(Najava user) {
        this.user = user;
    }

    public AdminKey() {

    }

    public Najava getUser() {
        return user;
    }

    public void setUser(Najava user) {
        this.user = user;
    }

}
