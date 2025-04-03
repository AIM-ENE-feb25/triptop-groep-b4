package triptop.groepB4.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import triptop.groepB4.domein.Vlucht;
import triptop.groepB4.state.Betaald;
import triptop.groepB4.state.Geregeld;
import triptop.groepB4.state.Niet_uitvoerbaar;
import triptop.groepB4.state.Uitgevoerd;
import triptop.groepB4.strategy.ApiGateway;

@Service
public class VluchtService implements VluchtServicePoort {

    private final ApiGateway apiGateway;

    public VluchtService() {
        this.apiGateway = new ApiGateway();
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
