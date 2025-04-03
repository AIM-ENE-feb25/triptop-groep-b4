package triptop.groepB4.strategy;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.http.ResponseEntity;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
public class ApiGateway {

    private ApiState state;
    private final String rapidApiKey = "8fd6c45fc2mshabe221890633f2cp13b92ajsne074069107fa";
    private final AsyncHttpClient client;

    public ApiGateway() {
        this.client = new DefaultAsyncHttpClient();
        this.state = new WorkingState();
    }

    public ResponseEntity<String> getFlights() {
        String url = "https://sky-scrapper.p.rapidapi.com/api/v2/flights/searchFlightsComplete"
                + "?originSkyId=LOND&destinationSkyId=NYCA&originEntityId=27544008"
                + "&destinationEntityId=27537542&date=2025-04-07&returnDate=2025-04-11"
                + "&cabinClass=economy&adults=1&sortBy=best&currency=EUR&market=en-US&countryCode=US";
        return state.execute(this, url);
    }

    public ResponseEntity<String> getFlightDetails(String itineraryId, String sessionId, String origin, String destination, String date) {
        String legs = "[{\"origin\":\"" + origin + "\",\"destination\":\"" + destination + "\",\"date\":\"" + date + "\"}]";

        String encodedItineraryId = URLEncoder.encode(itineraryId, StandardCharsets.UTF_8);
        String encodedSessionId = URLEncoder.encode(sessionId, StandardCharsets.UTF_8);
        String encodedLegs = URLEncoder.encode(legs, StandardCharsets.UTF_8);

        String url = "https://sky-scrapper.p.rapidapi.com/api/v1/flights/getFlightDetails"
                + "?itineraryId=" + encodedItineraryId
                + "&legs=" + encodedLegs
                + "&sessionId=" + encodedSessionId
                + "&adults=1&currency=EUR&locale=en-US&market=en-US&cabinClass=economy&countryCode=US";

        return state.execute(this, url);
    }

    public ResponseEntity<String> fetchResponse(String url){
        CompletableFuture<Response> futureResponse = client.prepareGet(url)
                .setHeader("x-rapidapi-key", rapidApiKey)
                .setHeader("x-rapidapi-host", "sky-scrapper.p.rapidapi.com")
                .execute()
                .toCompletableFuture();

        Response response = futureResponse.join();

        if (response.getStatusCode() == 200) {
            return ResponseEntity.ok(response.getResponseBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Error: " + response.getResponseBody());
        }
    }

    public ResponseEntity<String> getCache() {
        //TODO cache afhandeling
        return ResponseEntity.badRequest().body("Cache nog te implementeren");
    }
    public ApiState getState() {
        return state;
    }
    public void setState(ApiState state) {
        this.state = state;
    }
}
