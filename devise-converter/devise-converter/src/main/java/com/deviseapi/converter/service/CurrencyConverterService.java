package com.deviseapi.converter.service;

import com.deviseapi.converter.dto.ConversionRequest;
import com.deviseapi.converter.dto.ConversionResponse;
import com.deviseapi.converter.dto.ExchangeRateResponse;
import com.deviseapi.converter.exception.CurrencyConversionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class CurrencyConverterService {

    private final WebClient webClient;

    @Value("${api.exchangerates.api-key}")
    private String apiKey;

    public CurrencyConverterService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.apilayer.com/exchangerates_data").build();
    }

    public ConversionResponse convert(ConversionRequest request) {
        String from = request.getFrom();
        String to = request.getTo();
        double amount = request.getAmount();

        try {
            ExchangeRateResponse rateResponse = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                    .path("/latest")
                    .queryParam("base", from)
                    .queryParam("symbols", to)
                    .build())
                .header("apikey", apiKey)
                .retrieve()
                .bodyToMono(ExchangeRateResponse.class)
                .block();

            if (rateResponse == null || !rateResponse.isSuccess()) {
                throw new CurrencyConversionException("Erreur lors de la récupération des taux de change.");
            }

            Double rate = rateResponse.getRates().get(to);
            if (rate == null) {
                throw new CurrencyConversionException("Devise cible invalide : " + to);
            }

            double convertedAmount = amount * rate;

            return new ConversionResponse(from, to, amount, convertedAmount, rate);

        } catch (WebClientResponseException e) {
            throw new CurrencyConversionException("Erreur de l'API externe, devise invalide, (ex: EUR, USD) " + e.getStatusCode());
        } catch (Exception e) {
            throw new CurrencyConversionException("Erreur inconnue survenue : " + e.getMessage());
        }
    }

}
