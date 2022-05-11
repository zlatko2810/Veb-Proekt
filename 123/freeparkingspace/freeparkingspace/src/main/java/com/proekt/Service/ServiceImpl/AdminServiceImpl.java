package com.proekt.Service.ServiceImpl;

import com.proekt.Repository.AdministratorRepository;
import com.proekt.Repository.NajavaRepository;
import com.proekt.Service.AdminService;
import com.proekt.Service.EmployeeService;
import com.proekt.model.Admin.AdminKey;
import com.proekt.model.Admin.Administrator;
import com.proekt.model.Najava;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final NajavaRepository najavaRepository;
    private final AdministratorRepository administratorRepository;

    public AdminServiceImpl(NajavaRepository najavaRepository, AdministratorRepository administratorRepository) {
        this.najavaRepository = najavaRepository;
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator delete(String id) {
        Najava najava2 = najavaRepository.findById(id).get();
        AdminKey vrabotenKey1 = new AdminKey(najava2);
        Administrator vraboten3 = administratorRepository.findById(vrabotenKey1).get();
        this.administratorRepository.delete(vraboten3);
        return vraboten3;
    }

}
