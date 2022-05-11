package com.proekt.Controller;


import com.proekt.Repository.ParkingMestoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation-info")
public class ReservationInfo {

    private final ParkingMestoRepository parkingMestoRepository;

    public ReservationInfo(ParkingMestoRepository parkingMestoRepository) {
        this.parkingMestoRepository = parkingMestoRepository;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("parking_mesto", this.parkingMestoRepository.findAll());
        model.addAttribute("bodyContent","reservationInfo");
        return "master-template";
    }
}
