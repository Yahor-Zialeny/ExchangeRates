package com.example.exchangeratesmicroservice.Services;

import com.example.exchangeratesmicroservice.Models.Currency;
import com.example.exchangeratesmicroservice.Repositories.CurrencyRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {
    private CurrencyRepo currencyRepo;
    public CurrencyService(CurrencyRepo currencyRepo) {
        this.currencyRepo = currencyRepo;
    }

    @Override
    public Currency getCurrencyById(long id) {
        return currencyRepo.findById(id).get();
    }

    @Override
    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        currencyRepo.findAll().forEach(currencies::add);
        return currencies;
    }

    @Override
    public Currency updateCurrency(Currency currency) {
        return currencyRepo.save(currency);
    }

    @Override
    public void deleteCurrencyById(long id) {
        currencyRepo.deleteById(id);
    }

    @Override
    public Currency getCurrencyViaAPI(long id) {
        String url = "https://api.nbrb.by/exrates/currencies/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Object response = restTemplate.getForObject(url, Object.class);
        System.out.println(response);
        Currency currency = restTemplate.getForObject(url, Currency.class);
        return currency;
    }
}
