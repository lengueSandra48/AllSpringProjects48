package com.deviseapi.converter.dto;

public class ConversionResponse {

    private String from;
    private String to;
    private double amount;
    private double convertedAmount;
    private double rate;

    public ConversionResponse(String from, String to, double amount, double convertedAmount, double rate) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.rate = rate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public double getRate() {
        return rate;
    }
}
