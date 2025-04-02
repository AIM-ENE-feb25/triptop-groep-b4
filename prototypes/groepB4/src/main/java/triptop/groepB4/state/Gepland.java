package triptop.groepB4.state;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;
import triptop.groepB4.service.HotelService;
import triptop.groepB4.service.HotelServicePoort;
import triptop.groepB4.service.VluchtService;
import triptop.groepB4.service.VluchtServicePoort;

public class Gepland implements  BookingState{

    VluchtServicePoort vluchtServicePoort = new VluchtService();
    HotelServicePoort hotelServicePoort = new HotelService();

    @Override
    public void stateActie(Hotel hotel, String actie) {
        if (actie == "Book"){
            hotelServicePoort.BookHotel(hotel);
        } else {
            System.out.println("Deze actie: "+ actie + " is niet mogelijk bij de huidige state " + hotel.getState());
        }
    }

    @Override
    public void stateActie(Vlucht vlucht, String actie) {
        if (actie == "Book"){
            vluchtServicePoort.BookFlight(vlucht);
        } else {
            System.out.println("Deze actie: "+ actie + " is niet mogelijk bij de huidige state " + vlucht.getState());
        }
    }

    @Override
    public void cancelBooking(Hotel hotel) {
        hotelServicePoort.CancelHotelBooking(hotel);
    }

    @Override
    public void cancelBooking(Vlucht vlucht) {
        vluchtServicePoort.CancelFlightBooking(vlucht);
    }
}
