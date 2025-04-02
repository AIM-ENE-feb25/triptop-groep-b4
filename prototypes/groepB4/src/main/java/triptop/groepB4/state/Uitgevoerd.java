package triptop.groepB4.state;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;
import triptop.groepB4.service.HotelService;
import triptop.groepB4.service.HotelServicePoort;
import triptop.groepB4.service.VluchtService;
import triptop.groepB4.service.VluchtServicePoort;

public class Uitgevoerd implements BookingState{
    @Override
    public void stateActie(Hotel hotel, String actie) {
        System.out.println("Deze actie:"+ actie + "bij de huidige state " + hotel.getState());
    }

    @Override
    public void stateActie(Vlucht vlucht, String actie) {
        System.out.println("Deze actie:"+ actie + "bij de huidige state " + vlucht.getState());
    }

    @Override
    public void cancelBooking(Hotel hotel) {
        System.out.println("Deze actie: annuleren bij de huidige state " + hotel.getState());
    }

    @Override
    public void cancelBooking(Vlucht vlucht) {
        System.out.println("Deze actie: annuleren bij de huidige state " + vlucht.getState());
    }
}
