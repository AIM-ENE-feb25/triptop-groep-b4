package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;

public class HotelActionManager implements HotelActionHandler {
    @Override
    public void BookHotel(Hotel hotel) {
        hotel.BookHotel();
    }

    @Override
    public void PayHotelBooking(Hotel hotel) {
        hotel.PayHotelBooking();
    }

    @Override
    public void CancelHotelBooking(Hotel hotel) {
        hotel.CancelHotelBooking();
    }
}
