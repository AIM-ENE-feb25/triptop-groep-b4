package triptop.groepB4.state;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;

public class Niet_uitvoerbaar implements BookingState{
    @Override
    public void stateActie(Hotel hotel) {

    }

    @Override
    public void stateActie(Vlucht vlucht) {

    }

    @Override
    public void cancelBooking(Hotel hotel) {

    }

    @Override
    public void cancelBooking(Vlucht vlucht) {

    }
}
