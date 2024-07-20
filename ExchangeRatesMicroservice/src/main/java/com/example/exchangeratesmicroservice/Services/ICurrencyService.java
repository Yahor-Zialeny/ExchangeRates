package com.example.exchangeratesmicroservice.Services;

import com.example.exchangeratesmicroservice.Models.Currency;

import java.util.List;

public interface ICurrencyService {
    public Currency getCurrencyById(long id);
    public List<Currency> getAllCurrencies();
    public Currency updateCurrency(Currency currency);
    public void deleteCurrencyById(long id);
}
