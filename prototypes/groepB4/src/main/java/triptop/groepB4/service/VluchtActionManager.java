package triptop.groepB4.service;

import triptop.groepB4.domein.Vlucht;

public class VluchtActionManager implements VluchtActionHandler{

    @Override
    public void BookFlight(Vlucht vlucht) {
        vlucht.BookFlight();
    }

    @Override
    public void PayFlightBooking(Vlucht vlucht) {
        vlucht.PayFlightBooking();
    }

    @Override
    public void CancelFlightBooking(Vlucht vlucht) {
        vlucht.CancelFlightBooking();
    }
}
