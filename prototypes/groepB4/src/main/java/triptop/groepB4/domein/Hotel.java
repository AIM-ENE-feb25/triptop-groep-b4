package triptop.groepB4.domein;

import triptop.groepB4.state.BookingState;
import triptop.groepB4.state.Gepland;

public class Hotel {
    private int hotelId;
    private String hotelName;
    private BookingState state;

    public Hotel(int hotelId, String hotelName, BookingState state) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.state = state;
    }

    public Hotel(int hotelId, String hotelName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        state = new Gepland();
    }

    public void BookHotel(){
        state.stateActie(this, "Book");
    }
    public void PayHotelBooking(){
        state.stateActie(this, "Pay");
    }
    public void CancelHotelBooking(){
        state.cancelBooking(this);
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public BookingState getState() {
        return state;
    }

    public void setState(BookingState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", state=" + state +
                '}';
    }
}
