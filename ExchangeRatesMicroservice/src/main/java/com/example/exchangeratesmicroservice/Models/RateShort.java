package com.example.exchangeratesmicroservice.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shortrates")
public class RateShort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Cur_ID;
    private String Date;
    private Double Cur_OfficialRate;
}
