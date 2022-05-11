package com.proekt.Repository;

import com.proekt.model.Korisnik.Korisnik;
import com.proekt.model.Korisnik.KorisnikKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, KorisnikKey> {
}