package com.example.BookingComAPIPrototype.service;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class HotelService {
    private static final String API_URL = "https://booking-com15.p.rapidapi.com/api/v1/hotels";
    private static final String API_KEY = "a0c8294e56msh6d587bbeecb2191p116bbajsn98a3acbd29be";

    public CompletableFuture<String> getHotelData(String city, String checkInDate, String checkOutDate) {
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
}
