package com.example.exchangeratesmicroservice.Repositories;

import com.example.exchangeratesmicroservice.Models.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepo extends CrudRepository<Currency, Long> {
}
