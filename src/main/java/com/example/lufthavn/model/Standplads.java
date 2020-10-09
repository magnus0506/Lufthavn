package com.example.lufthavn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Standplads {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String standpladsnr;
    private String status;
    private String size;
    private String parkedplane;
    public Standplads() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParkedplane() {
        return parkedplane;
    }

    public void setParkedplane(String parkedplane) {
        this.parkedplane = parkedplane;
    }

    public String getStandpladsnr() {
        return standpladsnr;
    }

    public void setStandpladsnr(String standpladsnr) {
        this.standpladsnr = standpladsnr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}
