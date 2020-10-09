package com.example.lufthavn.repository;

import com.example.lufthavn.model.MediumSize;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MediumSizeRepository extends CrudRepository<MediumSize, Long> {
    @Query ("select s from MediumSize s")
    List<MediumSize> findAll(String keyword);
}
