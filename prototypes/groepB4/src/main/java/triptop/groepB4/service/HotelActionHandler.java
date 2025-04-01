package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;

public interface HotelActionHandler {
    public void BookHotel(Hotel hotel);
    public void PayHotelBooking(Hotel hotel);
    public void CancelHotelBooking(Hotel hotel);
}
