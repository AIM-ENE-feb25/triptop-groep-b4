package triptop.groepB4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import triptop.groepB4.domein.Vlucht;
import triptop.groepB4.service.VluchtActionHandler;
import triptop.groepB4.service.VluchtActionManager;
import triptop.groepB4.service.VluchtService;

@RestController
public class VluchtController {
    private final VluchtService vluchtService;
    VluchtActionHandler vluchtActionHandler = new VluchtActionManager();

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

    @PostMapping("/BookFlight")
    public void BookFlight() {
        Vlucht vlucht = checkIfExists(1);
        vluchtActionHandler.BookFlight(vlucht);
    }

    @PostMapping("/PayFlight")
    public void PayFlightBooking() {
        Vlucht vlucht = checkIfExists(1);
        vluchtActionHandler.PayFlightBooking(vlucht);
    }

    @PostMapping("/CancelFlightBooking")
    public void CancelFlightBooking() {
        Vlucht vlucht = checkIfExists(1);
        vluchtActionHandler.CancelFlightBooking(vlucht);
    }

    @PostMapping("/VoerVLuchtUit")
    public void VoerVLuchtUit() {
        Vlucht vlucht = new Vlucht(1);
        vluchtActionHandler.VoerVluchtUit(vlucht);
    }

    public Vlucht checkIfExists(int id) {
        Vlucht vlucht = vluchtActionHandler.getVlucht(id);
        if (vlucht == null) {
            vlucht = new Vlucht(id);
            vluchtActionHandler.NewVlucht(vlucht);
        }
        return vlucht;
    }

}
