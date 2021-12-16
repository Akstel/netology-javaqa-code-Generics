package ru.netology.domain;

public class Trip implements Comparable<Trip> {
    private int id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;


    public Trip(int id, int cost, String departureAirport, String arrivalAirport, int travelTime) {
        this.id = id;
        this.cost = cost;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public int compareTo(Trip o) {
        Trip p = o;
        return cost - p.cost;
    }

}
