package com.example.lufthavn.repository;

import com.example.lufthavn.model.ArrDep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArrDepRepository extends JpaRepository<ArrDep, Long> {

}
