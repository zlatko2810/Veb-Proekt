package com.proekt.Repository;

import com.proekt.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {
}