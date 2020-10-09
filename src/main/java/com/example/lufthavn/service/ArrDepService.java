package com.example.lufthavn.service;

import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.repository.ArrDepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArrDepService {

    @Autowired
    private ArrDepRepository repository;

    public Page<ArrDep> listAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 100);

        return repository.findAll(pageable);
    }

    public void save(ArrDep arrDep){
        repository.save(arrDep);
    }

    public ArrDep findById(Long id) {
        Optional<ArrDep> arrDepOptional = repository.findById(id);
        if (arrDepOptional.isEmpty())
        {
            throw new RuntimeException("");
        }
        return arrDepOptional.get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
