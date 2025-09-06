package com.deviseapi.converter.dto;

public class ConversionRequest {

    private String from;
    private String to;
    private double amount;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from.toUpperCase();  // Assure que la devise soit en majuscule
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.toUpperCase();  // Assure que la devise soit en majuscule
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
