package triptop.groepB4.domein;

import triptop.groepB4.state.BookingState;
import triptop.groepB4.state.Gepland;

public class Vlucht {
    private int flightId;

    public Vlucht(int flightId, BookingState state) {
        this.flightId = flightId;
        this.state = state;
    }

    public Vlucht(int flightId) {
        this.flightId = flightId;
        state = new Gepland();
    }

    public void BookFlight(){

    }
    public void PayFlightBooking(){

    }
    public void CancelFlightBooking(){

    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public BookingState getState() {
        return state;
    }

    public void setState(BookingState state) {
        this.state = state;
    }

    private BookingState state;


}
