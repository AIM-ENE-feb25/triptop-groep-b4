package triptop.groepB4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @PostMapping("/BookHotel")
    public void BookHotel(){

    }
    @PostMapping("/PayHotel")
    public void PayHotelBooking(){

    }

    @PostMapping("/CancelHotelBooking")
    public void CancelHotelBooking(){

    }
}
