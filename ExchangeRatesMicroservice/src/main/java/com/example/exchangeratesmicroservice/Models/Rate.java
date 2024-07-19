package com.example.exchangeratesmicroservice.Models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Data
@Table(name = "rates")
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
