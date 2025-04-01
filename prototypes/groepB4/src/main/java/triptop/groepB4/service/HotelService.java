package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;

public class HotelService implements HotelServicePoort {
    @Override
    public void BookHotel(Hotel hotel) {
        System.out.println("Hotel geboekt!!");
    }

    @Override
    public void PayHotelBooking(Hotel hotel) {
        System.out.println("Hotel betaald!!");
    }

    @Override
    public void CancelHotelBooking(Hotel hotel) {
        System.out.println("Hotel boeking geannuleerd :(");
    }
}
