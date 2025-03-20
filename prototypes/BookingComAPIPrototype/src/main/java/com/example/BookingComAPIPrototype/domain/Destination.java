package com.example.BookingComAPIPrototype.domain;

public class Destination {
    private String destId;
    private String searchType;
    private String name;

    public Destination(String destId, String searchType, String name) {
        this.destId = destId;
        this.searchType = searchType;
        this.name = name;
    }

    // Getters and setters
    public String getDestId() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId = destId;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "destId='" + destId + '\'' +
                ", searchType='" + searchType + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
