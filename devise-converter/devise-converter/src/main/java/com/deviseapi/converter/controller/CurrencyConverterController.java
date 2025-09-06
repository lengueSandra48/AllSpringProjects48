package com.deviseapi.converter.controller;

import com.deviseapi.converter.dto.ConversionRequest;
import com.deviseapi.converter.dto.ConversionResponse;
import com.deviseapi.converter.service.CurrencyConverterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversion")
public class CurrencyConverterController {

    private final CurrencyConverterService converterService;

    public CurrencyConverterController(CurrencyConverterService converterService) {
        this.converterService = converterService;
    }

    @PostMapping
    @Operation(summary = "Conversion d'une devise à ue autre")
    public ConversionResponse convert(@RequestBody ConversionRequest request) {
        return converterService.convert(request);
    }
}
