package triptop.groepB4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import triptop.groepB4.service.VluchtService;

@RestController
@RequestMapping("/api")
public class VluchtController {
    private final VluchtService vluchtService;

    public VluchtController(VluchtService vluchtService) {
        this.vluchtService = vluchtService;
    }

    @GetMapping("/getFlights")
    public ResponseEntity<String> getFlights() {
        return vluchtService.getFlights();
    }

    @GetMapping("/getFlightDetails")
    public ResponseEntity<String> getFlightDetails(
            @RequestParam String itineraryId,
            @RequestParam String sessionId,
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String date) {
        return vluchtService.getFlightDetails(itineraryId, sessionId, origin, destination, date);
    }

    @GetMapping("/PayFlight")
    public void PayFlightBooking() {

    }

    @GetMapping("/CancelFlightBooking")
    public void CancelFlightBooking() {

    }
}
