package com.example.BookingComAPIPrototype.controller;

import com.example.BookingComAPIPrototype.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

@RestController
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public CompletableFuture<String> getHotels(
            @RequestParam String city,
            @RequestParam String checkInDate,
            @RequestParam String checkOutDate) {
        return hotelService.getHotelData(city, checkInDate, checkOutDate);
    }
}
