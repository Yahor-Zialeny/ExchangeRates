package com.example.exchangeratesmicroservice.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Data
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Cur_ID")
    private Long Cur_ID;
    @JsonProperty("Date")
    private String Date;
    @JsonProperty("Cur_Abbreviation")
    private String Cur_Abbreviation;
    @JsonProperty("Cur_Scale")
    private long Cur_Scale;
    @JsonProperty("Cur_Name")
    private String Cur_Name;
    @JsonProperty("Cur_OfficialRate")
    private Double Cur_OfficialRate;

}
