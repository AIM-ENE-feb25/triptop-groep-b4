package com.example.BookingComAPIPrototype.service;

import com.example.BookingComAPIPrototype.domain.Destination;
import com.example.BookingComAPIPrototype.domain.Hotel;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    private static final String API_URL = "https://booking-com15.p.rapidapi.com/api/v1/hotels";
    private static final String API_KEY = "a0c8294e56msh6d587bbeecb2191p116bbajsn98a3acbd29be";

    public CompletableFuture<String> GetDestinationData(String city) {
        AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient();

        return asyncHttpClient
                .prepareGet(API_URL + "/searchDestination?")
                .addHeader("X-RapidAPI-Key", API_KEY)
                .addHeader("X-RapidAPI-Host", "booking-com15.p.rapidapi.com")
                .addQueryParam("query", city)
                .execute()
                .toCompletableFuture()
                .thenApply(Response::getResponseBody)
                .whenComplete((body, throwable) -> {
                    try {
                        asyncHttpClient.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public CompletableFuture<List<Hotel>> GetHotelList(String city, String checkInDate, String checkOutDate) {
        CompletableFuture<List<Destination>> destinationListFuture = GetDestinationDataList(city);

        return destinationListFuture.thenCompose(destinationList -> {
            List<CompletableFuture<List<Hotel>>> hotelFutures = new ArrayList<>();

            for (Destination destination : destinationList) {
                hotelFutures.add(GetHotelsForDestination(destination, checkInDate, checkOutDate));
            }

            // Combine all hotel futures into one list
            return CompletableFuture.allOf(hotelFutures.toArray(new CompletableFuture[0]))
                    .thenApply(voidResult -> {
                        List<Hotel> allHotels = new ArrayList<>();
                        for (CompletableFuture<List<Hotel>> future : hotelFutures) {
                            allHotels.addAll(future.join());
                        }
                        return allHotels;
                    });
        });
    }

    private CompletableFuture<List<Hotel>> GetHotelsForDestination(Destination destination, String checkInDate, String checkOutDate) {
        AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient();

        return asyncHttpClient
                .prepareGet(API_URL + "/searchHotels?")
                .addHeader("X-RapidAPI-Key", API_KEY)
                .addHeader("X-RapidAPI-Host", "booking-com15.p.rapidapi.com")
                .addQueryParam("dest_id", destination.getDestId())
                .addQueryParam("search_type", destination.getSearchType())
                .addQueryParam("arrival_date", checkInDate)
                .addQueryParam("departure_date", checkOutDate)
                .execute()
                .toCompletableFuture()
                .thenApply(response -> {
                    try {
                        // Parse the response
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode rootNode = objectMapper.readTree(response.getResponseBody());

                        // Access the `hotels` array inside `data`
                        JsonNode hotelsNode = rootNode.path("data").path("hotels");
                        if (hotelsNode == null || !hotelsNode.isArray() || hotelsNode.size() == 0) {
                            throw new RuntimeException("No hotel data found in response.");
                        }

                        List<Hotel> hotelList = new ArrayList<>();
                        for (JsonNode hotelNode : hotelsNode) {
                            // Extract data for each hotel
                            String id = hotelNode.path("hotel_id").asText();
                            String name = hotelNode.path("property").path("name").asText();
                            int reviewCount = hotelNode.path("property").path("reviewCount").asInt();
                            double reviewScore = hotelNode.path("property").path("reviewScore").asDouble();

                            // Handle photoUrls as a list
                            List<String> photoUrls = new ArrayList<>();
                            JsonNode photosNode = hotelNode.path("property").path("photoUrls");
                            if (photosNode != null && photosNode.isArray()) {
                                for (JsonNode photoNode : photosNode) {
                                    photoUrls.add(photoNode.asText());
                                }
                            }

                            String checkin = hotelNode.path("property").path("checkin").toString();
                            String checkoutDate = hotelNode.path("property").path("checkoutDate").asText();
                            String checkinDate = hotelNode.path("property").path("checkinDate").asText();
                            String checkout = hotelNode.path("property").path("checkout").toString();

                            // Handle priceBreakdown as a map
                            Map<String, Object> priceBreakdown = objectMapper.convertValue(
                                    hotelNode.path("property").path("priceBreakdown"), Map.class);

                            // Create and add Hotel object
                            Hotel hotel = new Hotel(id, name, reviewCount, reviewScore, photoUrls,
                                    checkin, checkoutDate, checkinDate, checkout, priceBreakdown);
                            hotelList.add(hotel);
                        }

                        return hotelList;
                    } catch (Exception e) {
                        throw new RuntimeException("Error parsing JSON response: " + e.getMessage(), e);
                    }
                })
                .whenComplete((body, throwable) -> {
                    try {
                        asyncHttpClient.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }





    public CompletableFuture<List<Destination>> GetDestinationDataList(String city) {
        CompletableFuture<String> destinationData = GetDestinationData(city);

        return destinationData.thenApply(destinationResponse -> {
            try {
                // Parse the JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(destinationResponse);
                JsonNode dataNode = rootNode.path("data");

                // Define a list to hold all destination objects
                List<Destination> destinationList = new ArrayList<>();

                // Iterate over the `data` array and add each item to the list
                for (JsonNode node : dataNode) {
                    String destId = node.path("dest_id").asText();
                    String searchType = node.path("search_type").asText();
                    String name = node.path("name").asText();

                    // Populate the custom Destination object
                    Destination destination = new Destination(destId, searchType, name);
                    destinationList.add(destination);
                }

                return destinationList;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

}
