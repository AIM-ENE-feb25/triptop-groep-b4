package triptop.groepB4.service;

import org.springframework.http.ResponseEntity;

public interface VluchtServicePoort {

    ResponseEntity<String> getFlights();

    ResponseEntity<String> getFlightDetails(String itineraryId, String sessionId, String origin, String destination, String date);

    public void bookFlight();
    public void payFlightBooking();
    public void cancelFlightBooking();
}
