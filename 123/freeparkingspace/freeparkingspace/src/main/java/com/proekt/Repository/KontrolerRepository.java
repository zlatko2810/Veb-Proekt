package com.proekt.Repository;

import com.proekt.model.Kontroler.Kontroler;
import com.proekt.model.Kontroler.KontrolerKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontrolerRepository extends JpaRepository<Kontroler, KontrolerKey> {
}