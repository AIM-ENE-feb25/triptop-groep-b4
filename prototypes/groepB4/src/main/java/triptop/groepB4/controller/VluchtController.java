package triptop.groepB4.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.asynchttpclient.*;
import org.springframework.beans.factory.annotation.Value;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class VluchtController {

    @Value("${rapidapi.key.vera}")
    private String rapidApiKey;

    @GetMapping("/getFlights")
    public ResponseEntity<String> getFlights() {
        String url = "https://sky-scrapper.p.rapidapi.com/api/v2/flights/searchFlightsComplete"
                + "?originSkyId=LOND&destinationSkyId=NYCA&originEntityId=27544008"
                + "&destinationEntityId=27537542&date=2025-04-07&returnDate=2025-04-11"
                + "&cabinClass=economy&adults=1&sortBy=best&currency=EUR&market=en-US&countryCode=US";

        try (AsyncHttpClient client = new DefaultAsyncHttpClient()) {
            return getfutureResonse(url, client);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Foutmelding bij het ophalen van vluchten: " + e.getMessage());
        }
    }

    @GetMapping("/getFlightDetails")
    public ResponseEntity<String> getFlightDetails(
            @RequestParam String itineraryId,
            @RequestParam String sessionId,
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String date) {

        // Legs array ombouwen naar gevraagde API formaat
        String legs = "[{\"origin\":\"" + origin + "\",\"destination\":\"" + destination + "\",\"date\":\"" + date + "\"}]";

        // Encodeer parameters zodat deze in de URL gebruikt kunnen worden
        String encodedItineraryId = URLEncoder.encode(itineraryId, StandardCharsets.UTF_8);
        String encodedSessionId = URLEncoder.encode(sessionId, StandardCharsets.UTF_8);
        String encodedLegs = URLEncoder.encode(legs, StandardCharsets.UTF_8);

        String url = "https://sky-scrapper.p.rapidapi.com/api/v1/flights/getFlightDetails"
                + "?itineraryId=" + encodedItineraryId
                + "&legs=" + encodedLegs
                + "&sessionId=" + encodedSessionId
                + "&adults=1&currency=EUR&locale=en-US&market=en-US&cabinClass=economy&countryCode=US";

        try (AsyncHttpClient client = new DefaultAsyncHttpClient()) {
            return getfutureResonse(url, client);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Foutmelding bij het ophalen van vlucht details: " + e.getMessage());
        }
    }

    @GetMapping("/PayFlight")
    public void PayFlightBooking() {

    }

    @GetMapping("/CancelFlightBooking")
    public void CancelFlightBooking() {

    }

    @NotNull
    private ResponseEntity<String> getfutureResonse(String url, AsyncHttpClient client) {
        CompletableFuture<Response> futureResponse = client.prepareGet(url)
                .setHeader("x-rapidapi-key", rapidApiKey)
                .setHeader("x-rapidapi-host", "sky-scrapper.p.rapidapi.com")
                .execute()
                .toCompletableFuture();

        Response response = futureResponse.join();

        if (response.getStatusCode() == 200) {
            return ResponseEntity.ok(response.getResponseBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getResponseBody());
        }
    }
}
