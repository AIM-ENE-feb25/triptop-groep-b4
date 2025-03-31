package org.example.airscraperapiprototype;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.stereotype.Service;

@Service
public class AirScraperService {

    public void fetchFlightData() {
        try (AsyncHttpClient client = new DefaultAsyncHttpClient()) {
            // Prepare the API call
            client.prepare("GET", "https://sky-scrapper.p.rapidapi.com/api/v2/flights/searchFlightsComplete"
                            + "?originSkyId=NZ"
                            + "&destinationSkyId=NYCA"
                            + "&originEntityId=27544008"
                            + "&destinationEntityId=27537542"
                            + "&date=2025-03-21"
                            + "&returnDate=2025-03-22"
                            + "&cabinClass=economy"
                            + "&adults=1"
                            + "&sortBy=best"
                            + "&limit=5"  // Lower limit to 5 for troubleshooting
                            + "&currency=EUR")
                    .setHeader("x-rapidapi-key", "8fd6c45fc2mshabe221890633f2cp13b92ajsne074069107fa")
                    .setHeader("x-rapidapi-host", "sky-scrapper.p.rapidapi.com")
                    .execute()
                    .toCompletableFuture()
                    .thenAccept(response -> {
                        System.out.println("Response: " + response.getResponseBody());
                    })
                    .join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
