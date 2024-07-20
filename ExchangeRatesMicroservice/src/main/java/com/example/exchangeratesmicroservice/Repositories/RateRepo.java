package com.example.exchangeratesmicroservice.Repositories;

import com.example.exchangeratesmicroservice.Models.Rate;
import org.springframework.data.repository.CrudRepository;

public interface RateRepo extends CrudRepository<Rate, Long> {
}
