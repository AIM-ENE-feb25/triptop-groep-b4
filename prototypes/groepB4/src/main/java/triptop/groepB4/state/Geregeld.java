package triptop.groepB4.state;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;
import triptop.groepB4.service.HotelService;
import triptop.groepB4.service.HotelServicePoort;
import triptop.groepB4.service.VluchtService;
import triptop.groepB4.service.VluchtServicePoort;

public class Geregeld implements BookingState{

    VluchtServicePoort vluchtServicePoort = new VluchtService();
    HotelServicePoort hotelServicePoort = new HotelService();
    @Override
    public void stateActie(Hotel hotel, String actie) {
        if (actie == "Pay"){
            hotelServicePoort.PayHotelBooking(hotel);
        } else {
            System.out.println("Deze actie: "+ actie + " bij de huidige state " + hotel.getState());
        }
    }

    @Override
    public void stateActie(Vlucht vlucht, String actie) {
        if (actie == "Pay"){
            vluchtServicePoort.PayFlightBooking(vlucht);
        } else {
            System.out.println("Deze actie: "+ actie + " bij de huidige state " + vlucht.getState());
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
