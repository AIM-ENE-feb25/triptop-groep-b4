package triptop.groepB4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VluchtController {

    @PostMapping("/BookFlight")
    public void BookFlight(){

    }
    @PostMapping("/PayFlight")
    public void PayFlightBooking(){

    }

    @PostMapping("/CancelFlightBooking")
    public void CancelFlightBooking(){

    }
}
