package com.proekt.model.Admin;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "administrator")
@Entity
public class Administrator{

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private AdminKey adminKey;

    private int idAdministrator;

    public Administrator(AdminKey adminKey, int idAdministrator) {
        this.adminKey = adminKey;
        this.idAdministrator = idAdministrator;
    }

    public Administrator() {
    }

    public AdminKey getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(AdminKey adminKey) {
        this.adminKey = adminKey;
    }

    public int getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(int idAdministrator) {
        this.idAdministrator = idAdministrator;
    }
}