package triptop.groepB4.service;

import triptop.groepB4.domein.Vlucht;

public interface VluchtServicePoort {

    public void BookFlight(Vlucht vlucht);
    public void PayFlightBooking(Vlucht vlucht);
    public void CancelFlightBooking(Vlucht vlucht);
    public void VoerVerblijfUit(Vlucht vlucht);
}
