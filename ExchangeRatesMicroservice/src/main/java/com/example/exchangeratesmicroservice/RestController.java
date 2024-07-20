package com.example.exchangeratesmicroservice;

import com.example.exchangeratesmicroservice.Models.Rate;
import com.example.exchangeratesmicroservice.Models.RateShort;
import com.example.exchangeratesmicroservice.Repositories.CurrencyRepo;
import com.example.exchangeratesmicroservice.Repositories.RateRepo;
import com.example.exchangeratesmicroservice.Repositories.RateShortRepo;
import com.example.exchangeratesmicroservice.Services.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("")
public class RestController {
    private final ICurrencyService currencyService;
    private final IRateShortService rateShortService;
    private final IRateService rateService;
    private static final String SUCCESS_STATUS = "success";
    private static final int CODE_SUCCESS = 100;
    public RestController(RateShortRepo rateShortRepo, RateRepo rateRepo, CurrencyRepo currencyRepo) {
        rateShortService = new RateShortService(rateShortRepo);
        rateService = new RateService(rateRepo);
        currencyService = new CurrencyService(currencyRepo);
    }
    @GetMapping
    public StandardResponse home(){
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @GetMapping("/getRate/{date}/{id}")
    public String getRates(@PathVariable String date, @PathVariable long id){
        try {
            Rate rate = rateService.getRate(date, id);
            return rate.toString();
        }catch (HttpClientErrorException e){
            String name = currencyService.getCurrencyViaAPI(id).getCur_Name();
            return "The currency "+ name + " went out of circulation";
        }
    }
    @PostMapping("/addRates/{date}")
    public StandardResponse addRates(@PathVariable String date){
        rateService.addRates(date);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
}
