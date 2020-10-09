package com.example.lufthavn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MediumSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    final int taxiFromArr = 10;
    final int passengersOut = 20;
    final int baggageOut = 35;
    final int fuelRefill = 55;
    final int cleaning = 95;
    final int baggageIn = 115;
    final int passengersIn = 135;
    final int taxiToDep = 145;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTaxiFromArr() {
        return taxiFromArr;
    }

    public  int getPassengersOut() {
        return passengersOut;
    }

    public  int getBaggageOut() {
        return baggageOut;
    }

    public  int getFuelRefill() {
        return fuelRefill;
    }

    public int getCleaning() {
        return cleaning;
    }

    public int getBaggageIn() {
        return baggageIn;
    }

    public int getPassengersIn() {
        return passengersIn;
    }

    public int getTaxiToDep() {
        return taxiToDep;
    }
}
