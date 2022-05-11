package com.proekt.Repository;

import com.proekt.model.Vraboten.Vraboten;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VrabotenRepository extends JpaRepository<Vraboten, String> {
}