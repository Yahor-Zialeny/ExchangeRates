package com.example.exchangeratesmicroservice.Services;

import com.example.exchangeratesmicroservice.Models.Currency;
import com.example.exchangeratesmicroservice.Repositories.CurrencyRepo;
import org.springframework.stereotype.Service;

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
}
