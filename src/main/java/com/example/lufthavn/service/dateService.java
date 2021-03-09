package com.example.lufthavn.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class dateService {

    public String calcDate(@RequestParam int year, int month, int day){
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(year, month, day);
        long daysDiff = LocalDate.now().until(endDate, ChronoUnit.DAYS);
        System.out.println(daysDiff);
        return  "" + daysDiff;
    }
}
