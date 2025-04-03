package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.state.Betaald;
import triptop.groepB4.state.Geregeld;
import triptop.groepB4.state.Niet_uitvoerbaar;
import triptop.groepB4.state.Uitgevoerd;

public class HotelService implements HotelServicePoort {
    private final ApiGateway apiGateway;

    public HotelService() {
        this.apiGateway = new ApiGateway();
    }

    @Override
    public void BookHotel(Hotel hotel) {
        hotel.setState(new Geregeld());
        System.out.println("Hotel geboekt!!");
        System.out.println(hotel.toString());
    }

    @Override
    public void PayHotelBooking(Hotel hotel) {
        hotel.setState(new Betaald());
        System.out.println("Hotel betaald!!");
        System.out.println(hotel.toString());
    }

    @Override
    public void CancelHotelBooking(Hotel hotel) {
        hotel.setState(new Niet_uitvoerbaar());
        System.out.println("Hotel boeking geannuleerd :(");
        System.out.println(hotel.toString());
    }

    @Override
    public void VoerVerblijfUit(Hotel hotel) {
        hotel.setState(new Uitgevoerd());
        System.out.println("Hotel boeking Uitgevoerd :)");
        System.out.println(hotel.toString());
    }
}
