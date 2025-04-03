package triptop.groepB4.service;

import triptop.groepB4.domein.Hotel;
import triptop.groepB4.domein.Vlucht;
import triptop.groepB4.state.Betaald;
import triptop.groepB4.state.Geregeld;
import triptop.groepB4.state.Niet_uitvoerbaar;
import triptop.groepB4.state.Uitgevoerd;

public class VluchtService implements VluchtServicePoort{
    @Override
    public void BookFlight(Vlucht vlucht) {
        vlucht.setState(new Geregeld());
        System.out.println("Vlucht geboekt!!");
        System.out.println(vlucht.toString());
    }

    @Override
    public void PayFlightBooking(Vlucht vlucht) {
        vlucht.setState(new Betaald());
        System.out.println("Vlucht betaald!!");
        System.out.println(vlucht.toString());
    }

    @Override
    public void CancelFlightBooking(Vlucht vlucht) {
        vlucht.setState(new Niet_uitvoerbaar());
        System.out.println("Vlucht boeking geannuleerd :(");
        System.out.println(vlucht.toString());
    }

    @Override
    public void VoerVluchtUit(Vlucht vlucht) {
        vlucht.setState(new Uitgevoerd());
        System.out.println("Vlucht boeking Uitgevoerd :)");
        System.out.println(vlucht.toString());
    }
}
