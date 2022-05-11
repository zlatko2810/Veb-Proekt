package com.proekt.Repository;

import com.proekt.model.Admin.AdminKey;
import com.proekt.model.Admin.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, AdminKey> {
}