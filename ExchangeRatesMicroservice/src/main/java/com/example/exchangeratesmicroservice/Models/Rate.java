package com.example.exchangeratesmicroservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date;


@Entity
@Data
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Cur_ID;
    private Date Date;
    private String Cur_Abbreviation;
    private long Cur_Scale;
    private String Cur_Name;
    private Double Cur_OfficialRate;
}
