package com.example.lufthavn.service;

import com.example.lufthavn.model.Standplads;
import com.example.lufthavn.repository.StandspladsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StandpladsService {
    @Autowired
    private StandspladsRepository repository;

    public Iterable<Standplads> listAll(){
        return repository.findAll();
    }

    public void save(Standplads standplads){
        repository.save(standplads);
    }

    public Standplads findById(Long id){
        Optional<Standplads> standpladsOptional = repository.findById(id);
        if (standpladsOptional.isEmpty()){
            throw new RuntimeException("Empty id");
        }
        return standpladsOptional.get();
    }
}
