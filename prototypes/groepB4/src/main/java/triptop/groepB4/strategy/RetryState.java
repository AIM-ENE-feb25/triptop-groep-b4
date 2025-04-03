package triptop.groepB4.strategy;

import org.springframework.http.ResponseEntity;

public class RetryState implements ApiState {
    private static final int MAX_RETRIES = 3;
    int counter = 0;

    @Override
    public ResponseEntity<String> execute(ApiGateway apiGateway, String url) {
        while (counter < MAX_RETRIES) {
            try {
                System.out.println("Poging " + (counter + 1));
                ResponseEntity<String> response = apiGateway.fetchResponse(url);

                if (response.getStatusCode().is2xxSuccessful()) {
                    System.out.println("Poging succesvol.");
                    apiGateway.setState(new WorkingState());
                    return response;
                }

                counter++;
            } catch (Exception e) {
                System.out.println("Poging mislukt: " + e.getMessage());
                counter++;
            }
        }

        System.out.println("Maximaal aantal pogingen behaald, state wordt FallbackState.");
        apiGateway.setState(new FallbackState());
        return apiGateway.getState().execute(apiGateway, url);
    }
}

//package triptop.groepB4.strategy;
//
//import org.springframework.http.ResponseEntity;
//
//public class RetryState implements ApiState {
//    private static final int MAX_RETRIES = 3;
//    int counter = 0;
//
//    @Override
//    public ResponseEntity<String> execute(ApiGateway apiGateway, String url) {
//        while (counter < MAX_RETRIES) {
//                System.out.println("Poging " + (counter + 1));
//                System.out.println("Poging mislukt. ");
//                counter++;
//        }
//
//        System.out.println("Maximaal aantal pogingen behaald, state wordt FallbackState.");
//        apiGateway.setState(new FallbackState());
//        return apiGateway.getState().execute(apiGateway, url);
//    }
//}

