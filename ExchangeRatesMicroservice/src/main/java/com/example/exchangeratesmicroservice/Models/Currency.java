package com.example.exchangeratesmicroservice.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Data
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Cur_ID")
    private Long Cur_id;
    @JsonProperty("Cur_ParentID")
    private Long Cur_ParentID;
    @JsonProperty("Cur_Code")
    private String Cur_Code;
    @JsonProperty("Cur_Abbreviation")
    private String Cur_Abbreviation;
    @JsonProperty("Cur_Name")
    private String Cur_Name;
    @JsonProperty("Cur_Name_Bel")
    private String Cur_Name_Bel;
    @JsonProperty("Cur_Name_Eng")
    private String Cur_Name_Eng;
    @JsonProperty("Cur_QuotName")
    private String Cur_QuotName;
    @JsonProperty("Cur_Quot_Bel")
    private String Cur_Quot_Bel;
    @JsonProperty("Cur_Quot_Eng")
    private String Cur_Quot_Eng;
    @JsonProperty("Cur_NameMulti")
    private String Cur_NameMulti;
    @JsonProperty("Cur_Name_BelMulti")
    private String Cur_Name_BelMulti;
    @JsonProperty("Cur_Name_EngMulti")
    private String Cur_Name_EngMulti;
    @JsonProperty("Cur_Scale")
    private int Cur_Scale;
    @JsonProperty("Cur_Periodicity")
    private int Cur_Periodicity;
    @JsonProperty("Cur_DateStart")
    private Date Cur_DateStart;
    @JsonProperty("Cur_DateEnd")
    private Date Cur_DateEnd;
}

