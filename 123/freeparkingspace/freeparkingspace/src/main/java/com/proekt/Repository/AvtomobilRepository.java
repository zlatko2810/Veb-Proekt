package com.proekt.Repository;

import com.proekt.model.Avtomobil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvtomobilRepository extends JpaRepository<Avtomobil, String> {
}