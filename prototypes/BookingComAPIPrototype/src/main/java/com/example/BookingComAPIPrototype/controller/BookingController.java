package com.example.BookingComAPIPrototype.controller;

import com.example.BookingComAPIPrototype.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/hotels")
    public CompletableFuture<String> getHotels(
            @RequestParam String city,
            @RequestParam String checkInDate,
            @RequestParam String checkOutDate) {
        return bookingService.getHotelData(city, checkInDate, checkOutDate);
    }
}
