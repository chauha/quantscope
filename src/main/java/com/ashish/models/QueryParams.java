package com.ashish.models;


import java.time.LocalDateTime;


public class QueryParams {

    LocalDateTime date;
    Frequency freq;

    public LocalDateTime getDate() {
        return date;
    }

    public Frequency getFreq() {
        return freq;
    }

    public QueryParams(LocalDateTime date, Frequency freq) {
        this.date = date;
        this.freq = freq;
    }
}
