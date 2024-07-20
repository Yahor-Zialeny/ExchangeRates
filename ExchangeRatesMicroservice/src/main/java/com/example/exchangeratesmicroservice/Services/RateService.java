package com.example.exchangeratesmicroservice.Services;

import com.example.exchangeratesmicroservice.Models.Rate;
import com.example.exchangeratesmicroservice.Repositories.RateRepo;
import com.example.exchangeratesmicroservice.StandardResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RateService implements IRateService {
    private RateRepo rateRepo;
    public RateService(RateRepo rateRepo) {
        this.rateRepo = rateRepo;
    }

    @Override
    public Rate updateRate(Rate rate) {
        return rateRepo.save(rate);
    }

    @Override
    public void deleteRate(Long id) {
        rateRepo.deleteById(id);
    }

    @Override
    public Rate getRateById(Long id) {
        return rateRepo.findById(id).get();
    }

    @Override
    public List<Rate> getAllRates() {
        List<Rate> rates = new ArrayList<>();
        rateRepo.findAll().forEach(rates::add);
        return rates;
    }

    @Override
    public void addRates(String date) {
        Map<Long, Rate> ratesMap = new HashMap<>();
        String url = "https://api.nbrb.by/exrates/rates?ondate=" + date + "&periodicity=0";
        RestTemplate restTemplate = new RestTemplate();
        Rate[] ratesArray = restTemplate.getForObject(url, Rate[].class);
        for (Rate rate : ratesArray) {
            ratesMap.put(rate.getCur_ID(), rate);
        }
        for (Rate rate : ratesMap.values()) {
            rateRepo.save(rate);
        }
    }

    @Override
    public Rate getRate(String date, Long id) {
        String url = "https://api.nbrb.by/exrates/rates/"+ id +"?ondate=" + date;
        RestTemplate restTemplate = new RestTemplate();
        Rate rate = restTemplate.getForObject(url, Rate.class);
        return rate;
    }
}
