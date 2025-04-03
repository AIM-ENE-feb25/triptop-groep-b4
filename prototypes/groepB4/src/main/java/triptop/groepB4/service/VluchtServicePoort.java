package triptop.groepB4.service;

import org.springframework.http.ResponseEntity;
import triptop.groepB4.domein.Vlucht;

public interface VluchtServicePoort {

    ResponseEntity<String> getFlights();

    ResponseEntity<String> getFlightDetails(String itineraryId, String sessionId, String origin, String destination, String date);

    void BookFlight(Vlucht vlucht);

    void PayFlightBooking(Vlucht vlucht);

    void CancelFlightBooking(Vlucht vlucht);

    void VoerVluchtUit(Vlucht vlucht);
}
