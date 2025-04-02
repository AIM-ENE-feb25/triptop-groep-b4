package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;

import java.util.ArrayList;

public class HotelActionManager implements HotelActionHandler {

    private ArrayList<Hotel> hotelList = new ArrayList<>();
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

    @Override
    public Hotel getHotel(int id){
        for (Hotel hotel : hotelList){
            if(hotel.getHotelId() == id){
                return hotel;
            }
        }
        return null;
    }

    @Override
    public void VoerBoekingUit(Hotel hotel) {
        hotel.VoerBoekingUit();
    }

    @Override
    public void NewHotel(Hotel hotel){
        hotelList.add(hotel);
    }
}
