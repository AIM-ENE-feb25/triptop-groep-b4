package triptop.groepB4.state;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;

public interface BookingState {

    public void stateActie(Hotel hotel);
    public void stateActie(Vlucht vlucht);
    public void cancelBooking(Hotel hotel);
    public void cancelBooking(Vlucht vlucht);
}
