package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;

public interface HotelActionHandler {
    public void BookHotel(Hotel hotel);
    public void PayHotelBooking(Hotel hotel);
    public void CancelHotelBooking(Hotel hotel);
    public Hotel getHotel(int id);
    public void VoerBoekingUit(Hotel hotel);
    public void NewHotel(Hotel hotel);
}
