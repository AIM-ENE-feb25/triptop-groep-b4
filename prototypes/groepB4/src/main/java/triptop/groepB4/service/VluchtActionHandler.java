package triptop.groepB4.service;

import triptop.groepB4.domein.Vlucht;

public interface VluchtActionHandler {

    public void BookFlight(Vlucht vlucht);
    public void PayFlightBooking(Vlucht vlucht);
    public void CancelFlightBooking(Vlucht vlucht);
}
