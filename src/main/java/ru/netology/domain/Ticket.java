package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;        //аэропорта вылета
    private String to;      //аэропорт прилёта
    private int travelTimeInMinutes;

    public Ticket(int id, int price, String from, String to, int travelTimeInMinutes) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.travelTimeInMinutes = travelTimeInMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTravelTimeInMinutes() {
        return travelTimeInMinutes;
    }

    public void setTravelTimeInMinutes(int travelTimeInMinutes) {
        this.travelTimeInMinutes = travelTimeInMinutes;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        return this.price - otherTicket.price;
    }
}
