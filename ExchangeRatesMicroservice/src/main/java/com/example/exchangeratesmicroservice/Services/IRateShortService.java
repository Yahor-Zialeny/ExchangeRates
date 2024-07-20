package com.example.exchangeratesmicroservice.Services;

import com.example.exchangeratesmicroservice.Models.Rate;
import com.example.exchangeratesmicroservice.Models.RateShort;

import java.util.List;

public interface IRateShortService {
    public RateShort getShortRateById(Long id);
    public List<RateShort> getAllShortRates();
    public RateShort updateShortRate(RateShort rate);
    public void deleteShortRate(Long id);
    public RateShort getRate(String date, long id);
}
