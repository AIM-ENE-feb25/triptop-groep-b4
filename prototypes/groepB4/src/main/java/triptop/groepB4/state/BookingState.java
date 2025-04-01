package triptop.groepB4.state;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;

public interface BookingState {

    public void stateActie(Hotel hotel, String actie);
    public void stateActie(Vlucht vlucht, String actie);
    public void cancelBooking(Hotel hotel);
    public void cancelBooking(Vlucht vlucht);
}
