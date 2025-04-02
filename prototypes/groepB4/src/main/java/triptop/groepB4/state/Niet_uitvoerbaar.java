package triptop.groepB4.state;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;

public class Niet_uitvoerbaar implements BookingState{
    @Override
    public void stateActie(Hotel hotel, String actie) {
            System.out.println("Deze actie: "+ actie + " bij de huidige state " + hotel.getState());
    }

    @Override
    public void stateActie(Vlucht vlucht, String actie) {
            System.out.println("Deze actie: "+ actie + " bij de huidige state " + vlucht.getState());
    }

    @Override
    public void cancelBooking(Hotel hotel) {
        System.out.println("De boeking is al geannuleerd voor: " + hotel.getState());
    }

    @Override
    public void cancelBooking(Vlucht vlucht) {
        System.out.println("De boeking is al geannuleerd voor: " + vlucht.getState());
    }
}
