package triptop.groepB4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import triptop.groepB4.domein.Vlucht;
import triptop.groepB4.service.VluchtActionHandler;
import triptop.groepB4.service.VluchtActionManager;

@RestController
public class VluchtController {

    VluchtActionHandler vluchtActionHandler = new VluchtActionManager();
    @PostMapping("/BookFlight")
    public void BookFlight(){
        Vlucht vlucht = checkIfExists(1);
        vluchtActionHandler.BookFlight(vlucht);
    }
    @PostMapping("/PayFlight")
    public void PayFlightBooking(){
        Vlucht vlucht = checkIfExists(1);
        vluchtActionHandler.PayFlightBooking(vlucht);
    }

    @PostMapping("/CancelFlightBooking")
    public void CancelFlightBooking(){
        Vlucht vlucht = checkIfExists(1);
        vluchtActionHandler.CancelFlightBooking(vlucht);
    }

    @PostMapping("/VoerVLuchtUit")
    public void VoerVLuchtUit(){
        Vlucht vlucht = new Vlucht(1);
        vluchtActionHandler.VoerVluchtUit(vlucht);
    }

    public Vlucht checkIfExists(int id){
        Vlucht vlucht = vluchtActionHandler.getVlucht(id);
        if (vlucht == null){
            vlucht = new Vlucht(id);
            vluchtActionHandler.NewVlucht(vlucht);
        }
        return vlucht;
    }
}
