package triptop.groepB4.state;

import org.springframework.http.ResponseEntity;
import triptop.groepB4.service.ApiGateway;

public class FallbackState implements ApiState {
    @Override
    public ResponseEntity<String> execute(ApiGateway apiGateway, String url) {
        try {
            ResponseEntity<String> response = apiGateway.fetchResponse(url);
            if (response.getStatusCode().is2xxSuccessful()) {
                apiGateway.setState(new WorkingState());
                System.out.println("API werkt weer, data wordt geladen");
                return response;
            }
        } catch (Exception e) {
            System.out.println("API Call foutmelding: " + e.getMessage());
        }
        System.out.println("API werkt niet, cache wordt geladen");
        return apiGateway.getCache();
    }
}

//package triptop.groepB4.strategy;
//
//import org.springframework.http.ResponseEntity;
//
//public class FallbackState implements ApiState {
//    @Override
//    public ResponseEntity<String> execute(ApiGateway apiGateway, String url) {
//        System.out.println("API Call foutmelding. " );
//        System.out.println("API werkt niet, cache wordt geladen");
//        return apiGateway.getCache();
//    }
//}
