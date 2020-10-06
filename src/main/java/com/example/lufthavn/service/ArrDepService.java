package com.example.lufthavn.service;

import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.repository.ArrDepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrDepService {
    @Autowired
    private ArrDepRepository repository;

    public List<ArrDep> listAll() {
        return repository.findAll();
    }

    public void save(ArrDep arrDep){
        repository.save(arrDep);
    }

    public ArrDep get(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
