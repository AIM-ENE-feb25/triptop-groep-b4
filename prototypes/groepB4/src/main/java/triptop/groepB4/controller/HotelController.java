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
        Hotel hotel = new Hotel(1,"test");
        hotelActionHandler.BookHotel(hotel);
    }
    @PostMapping("/PayHotel")
    public void PayHotelBooking(){
        Hotel hotel = new Hotel(1,"test");
        hotelActionHandler.PayHotelBooking(hotel);
    }

    @PostMapping("/CancelHotelBooking")
    public void CancelHotelBooking(){
        Hotel hotel = new Hotel(1,"test");
        hotelActionHandler.CancelHotelBooking(hotel);
    }
}
