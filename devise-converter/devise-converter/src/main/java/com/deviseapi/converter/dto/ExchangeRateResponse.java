package com.deviseapi.converter.dto;

import java.util.Map;

public class ExchangeRateResponse {
    private boolean success;
    private Map<String, Double> rates;

    public boolean isSuccess() {
        return success;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}
