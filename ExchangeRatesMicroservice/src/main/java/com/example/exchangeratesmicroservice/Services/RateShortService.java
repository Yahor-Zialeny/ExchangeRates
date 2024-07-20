package com.example.exchangeratesmicroservice.Services;

import com.example.exchangeratesmicroservice.Models.Rate;
import com.example.exchangeratesmicroservice.Models.RateShort;
import com.example.exchangeratesmicroservice.Repositories.RateShortRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RateShortService implements IRateShortService{
    private RateShortRepo rateShortRepo;
    public RateShortService(RateShortRepo rateShortRepo) {
        rateShortRepo = rateShortRepo;
    }

    @Override
    public RateShort getShortRateById(Long id) {
        return rateShortRepo.findById(id).get();
    }

    @Override
    public List<RateShort> getAllShortRates() {
        List<RateShort> rateShorts = new ArrayList<>();
        rateShortRepo.findAll().forEach(rateShorts::add);
        return rateShorts;
    }

    @Override
    public RateShort updateShortRate(RateShort rate) {
        return rateShortRepo.save(rate);
    }

    @Override
    public void deleteShortRate(Long id) {
        rateShortRepo.deleteById(id);
    }

    @Override
    public Rate getRates(String date, long id) {
        String url = "https://api.nbrb.by/exrates/rates/" + id + "?ondate=" + date;
        RestTemplate restTemplate = new RestTemplate();
        Rate rate = restTemplate.getForObject(url, Rate.class);
        return rate;
    }
}
