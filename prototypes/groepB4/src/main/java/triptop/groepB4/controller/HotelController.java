package triptop.groepB4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import triptop.groepB4.domein.Hotel;
import triptop.groepB4.service.HotelActionHandler;
import triptop.groepB4.service.HotelActionManager;

@RestController
public class HotelController {

    private HotelActionHandler hotelActionHandler = new HotelActionManager();

    @PostMapping("/BookHotel")
    public void BookHotel(){
        Hotel hotel = checkIfExists(1,"test");
        hotelActionHandler.BookHotel(hotel);
    }
    @PostMapping("/PayHotel")
    public void PayHotelBooking(){
        Hotel hotel = checkIfExists(1,"test");
        hotelActionHandler.PayHotelBooking(hotel);
    }

    @PostMapping("/CancelHotelBooking")
    public void CancelHotelBooking(){
        Hotel hotel = checkIfExists(1,"test");
        hotelActionHandler.CancelHotelBooking(hotel);
    }

    @PostMapping("/VoerBoekingUit")
    public void VoerBoekingUit(){
        Hotel hotel = checkIfExists(1,"test");
        hotelActionHandler.VoerBoekingUit(hotel);
    }

    public Hotel checkIfExists(int id, String hotelName){
        Hotel hotel = hotelActionHandler.getHotel(id);
        if (hotel == null){
            hotel = new Hotel(id, hotelName);
            hotelActionHandler.NewHotel(hotel);
        }
        return hotel;
    }
}
