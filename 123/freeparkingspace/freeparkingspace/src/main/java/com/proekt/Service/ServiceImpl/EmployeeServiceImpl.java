package com.proekt.Service.ServiceImpl;

import com.proekt.Repository.NajavaRepository;
import com.proekt.Repository.VrabotenRepository1;
import com.proekt.Service.EmployeeService;
import com.proekt.model.Najava;
import com.proekt.model.Vraboten.Vraboten;
import com.proekt.model.Vraboten.VrabotenKey;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final NajavaRepository najavaRepository;
    private final VrabotenRepository1 vrabotenRepository1;

    public EmployeeServiceImpl(NajavaRepository najavaRepository, VrabotenRepository1 vrabotenRepository1) {
        this.najavaRepository = najavaRepository;
        this.vrabotenRepository1 = vrabotenRepository1;
    }

    @Override
    public Vraboten delete(String id) {
        Najava najava2 = najavaRepository.findById(id).get();
        VrabotenKey vrabotenKey1 = new VrabotenKey(najava2);
        Vraboten vraboten3 = vrabotenRepository1.findById(vrabotenKey1).get();
        this.vrabotenRepository1.delete(vraboten3);
        return vraboten3;
    }

}
