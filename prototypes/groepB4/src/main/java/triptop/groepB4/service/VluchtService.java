package triptop.groepB4.service;

import triptop.groepB4.domein.Vlucht;

public class VluchtService implements VluchtServicePoort{
    @Override
    public void BookFlight(Vlucht vlucht) {
        System.out.println("vlucht geboekt!!");
    }

    @Override
    public void PayFlightBooking(Vlucht vlucht) {
        System.out.println("vlucht betaald!!");
    }

    @Override
    public void CancelFlightBooking(Vlucht vlucht) {
        System.out.println("vlucht boeking geannuleerd :(");
    }

    @Override
    public void VoerVerblijfUit(Vlucht vlucht) {

    }
}
