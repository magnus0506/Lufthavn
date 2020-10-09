package com.example.lufthavn.service;

import com.example.lufthavn.model.MediumSize;
import com.example.lufthavn.repository.MediumSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class MediumSizeService {

    @Autowired
    private MediumSizeRepository repository;

    public List<MediumSize> listAll(String keyword) {
        if (keyword != null) {
            return repository.findAll(keyword);
        }
        return repository.findAll(null);
    }

    public String addTime(int add){
        Calendar d = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        d.add(Calendar.MINUTE, add);
        return df.format(d.getTime());
    }
}
