package com.example.BookingComAPIPrototype.domain;

import java.util.List;
import java.util.Map;

public class Hotel {
    private String id;
    private String name;
    private int reviewCount;
    private double reviewScore;
    private List<String> photoUrls;
    private String checkin;
    private String checkoutDate;
    private String checkinDate;
    private String checkout;
    private Map<String, Object> priceBreakdown;

    // Constructor
    public Hotel(String id, String name, int reviewCount, double reviewScore, List<String> photoUrls,
                 String checkin, String checkoutDate, String checkinDate, String checkout,
                 Map<String, Object> priceBreakdown) {
        this.id = id;
        this.name = name;
        this.reviewCount = reviewCount;
        this.reviewScore = reviewScore;
        this.photoUrls = photoUrls;
        this.checkin = checkin;
        this.checkoutDate = checkoutDate;
        this.checkinDate = checkinDate;
        this.checkout = checkout;
        this.priceBreakdown = priceBreakdown;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getReviewCount() { return reviewCount; }
    public void setReviewCount(int reviewCount) { this.reviewCount = reviewCount; }

    public double getReviewScore() { return reviewScore; }
    public void setReviewScore(double reviewScore) { this.reviewScore = reviewScore; }

    public List<String> getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls; }

    public String getCheckin() { return checkin; }
    public void setCheckin(String checkin) { this.checkin = checkin; }

    public String getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(String checkoutDate) { this.checkoutDate = checkoutDate; }

    public String getCheckinDate() { return checkinDate; }
    public void setCheckinDate(String checkinDate) { this.checkinDate = checkinDate; }

    public String getCheckout() { return checkout; }
    public void setCheckout(String checkout) { this.checkout = checkout; }

    public Map<String, Object> getPriceBreakdown() { return priceBreakdown; }
    public void setPriceBreakdown(Map<String, Object> priceBreakdown) { this.priceBreakdown = priceBreakdown; }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", reviewCount=" + reviewCount +
                ", reviewScore=" + reviewScore +
                ", photoUrls=" + photoUrls +
                ", checkin='" + checkin + '\'' +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", checkinDate='" + checkinDate + '\'' +
                ", checkout='" + checkout + '\'' +
                ", priceBreakdown=" + priceBreakdown +
                '}';
    }
}
