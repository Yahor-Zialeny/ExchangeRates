package com.example.exchangeratesmicroservice;

import com.example.exchangeratesmicroservice.Models.Rate;
import com.example.exchangeratesmicroservice.Repositories.CurrencyRepo;
import com.example.exchangeratesmicroservice.Repositories.RateRepo;
import com.example.exchangeratesmicroservice.Repositories.RateShortRepo;
import com.example.exchangeratesmicroservice.Services.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("")
public class RestController {
    private final IRateShortService rateShortService;
    private final IRateService rateService;
    private static final String SUCCESS_STATUS = "success";
    private static final int CODE_SUCCESS = 100;
    public RestController(RateShortRepo rateShortRepo, RateRepo rateRepo) {
        rateShortService = new RateShortService(rateShortRepo);
        rateService = new RateService(rateRepo);
    }
    @GetMapping
    public StandardResponse home(){
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
    @PostMapping("/rateShort/{date}/{id}")
    public String getRates(@PathVariable String date, @PathVariable int id){
        Rate rate = rateShortService.getRates(date, id);
        return rate.toString();
    }
    @PostMapping("/rate/{date}")
    public StandardResponse addRates(@PathVariable String date){
        rateService.addRates(date);
        return new StandardResponse(SUCCESS_STATUS, CODE_SUCCESS);
    }
}
