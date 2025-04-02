package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;

public interface HotelServicePoort {
    public void BookHotel(Hotel hotel);
    public void PayHotelBooking(Hotel hotel);
    public void CancelHotelBooking(Hotel hotel);
    public void VoerVerblijfUit(Hotel hotel);
}
