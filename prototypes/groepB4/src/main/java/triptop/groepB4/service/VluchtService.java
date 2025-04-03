package triptop.groepB4.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import triptop.groepB4.strategy.ApiGateway;

@Service
public class VluchtService implements VluchtServicePoort {
    private final ApiGateway apiGateway;
    public VluchtService(@Value("${rapidapi.key.vera}") String rapidApiKey) {
        this.apiGateway = new ApiGateway(rapidApiKey);
    }

    @Override
    public ResponseEntity<String> getFlights() {
        return apiGateway.getFlights();
    }

    @Override
    public ResponseEntity<String> getFlightDetails(String itineraryId, String sessionId, String origin, String destination, String date) {
        return apiGateway.getFlightDetails(itineraryId, sessionId, origin, destination, date);
    }

    @Override
    public void bookFlight() {

    }

    @Override
    public void payFlightBooking() {

    }

    @Override
    public void cancelFlightBooking() {

    }
}
