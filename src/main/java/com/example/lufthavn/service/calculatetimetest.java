package com.example.lufthavn.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class calculatetimetest {
    static final int taxiFromArr = 10;
    static final int passengersOut=20;
    static final int baggageOut=35;
    static final int fuelRefill=55;
    static final int cleaning=95;
    static final int baggageIn=115;
    static final int passengersIn=135;
    static final int taxiToDep=145;

    static void addTime(int add){
        Calendar d = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        d.add(Calendar.MINUTE, add);
        String newTime = df.format(d.getTime());
        System.out.println(newTime);
    }

    static int calc(int x, int y){
     return x + y;
    }

    public static void main(String[] args) {

        Calendar d = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        String newTime = df.format(d.getTime());

        System.out.println("Klokken er nu: " + newTime);

        addTime(taxiFromArr);
        addTime(passengersOut);
        addTime(baggageOut);
        addTime(fuelRefill);
        addTime(cleaning);
        addTime(baggageIn);
        addTime(passengersIn);
        addTime(taxiToDep);

    }
}