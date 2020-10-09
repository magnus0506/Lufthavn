package com.example.lufthavn.service;

import com.example.lufthavn.model.Airport;
import com.example.lufthavn.model.ArrDep;
import com.example.lufthavn.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository repository;

    public Page<Airport> listAll(int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber - 1, 100);
                return repository.findAll(pageable);
    }

    public void save(Airport airport){
        repository.save(airport);
    }

    public Airport findById(Long id) {
        Optional<Airport> airportOptional = repository.findById(id);
        if (airportOptional.isEmpty())
        {
            throw new RuntimeException("");
        }
        return airportOptional.get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
