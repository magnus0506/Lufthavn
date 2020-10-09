package com.example.lufthavn.service;

import com.example.lufthavn.model.Standplads;
import com.example.lufthavn.repository.StandpladsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandpladsService {
    @Autowired
    private StandpladsRepository repository;

    public List<Standplads> listAll(String keyword) {
        if (keyword != null) {
            return repository.findAll(keyword);
        }
        return repository.findAll(null);
    }

    public List<Standplads> find(String keyword) {
        return repository.find(keyword);
    }

    public void save(Standplads standplads) {
        repository.save(standplads);
    }

    public Standplads findById(Long id) {
        Optional<Standplads> standpladsOptional = repository.findById(id);
        if (standpladsOptional.isEmpty()) {
            throw new RuntimeException("Empty id");
        }
        return standpladsOptional.get();
    }
}
