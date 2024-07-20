package com.example.exchangeratesmicroservice.Services;

import com.example.exchangeratesmicroservice.Models.Rate;
import com.example.exchangeratesmicroservice.StandardResponse;

import java.util.List;

public interface IRateService {
    public Rate getRateById(Long id);
    public List<Rate> getAllRates();
    public Rate updateRate(Rate rate);
    public void deleteRate(Long id);
    public void addRates(String date);
}
