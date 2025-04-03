package triptop.groepB4.strategy;

import org.springframework.http.ResponseEntity;

public class WorkingState implements ApiState {
    @Override
    public ResponseEntity<String> execute(ApiGateway apiGateway, String url) {
        try {
            return apiGateway.fetchResponse(url);
        } catch (Exception e) {
            System.out.println("API Call error: " + e.getMessage());
            apiGateway.setState(new RetryState());
            System.out.println("State changed to RetryState.");
            return apiGateway.getState().execute(apiGateway, url);
        }
    }
}

//package triptop.groepB4.strategy;
//
//import org.springframework.http.ResponseEntity;
//
//public class WorkingState implements ApiState {
//    @Override
//    public ResponseEntity<String> execute(ApiGateway apiGateway, String url) {
//        System.out.println("API Call error. ");
//        apiGateway.setState(new RetryState());
//        System.out.println("State changed to RetryState.");
//        return apiGateway.getState().execute(apiGateway, url);
//    }
//}
