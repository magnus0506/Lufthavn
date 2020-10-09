package com.example.lufthavn.repository;

import com.example.lufthavn.model.Standplads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StandpladsRepository extends CrudRepository<Standplads, Long> {
    @Query ("select s from Standplads s")
    List<Standplads> findAll(String keyword);

    @Query("select s from Standplads s where s.status = 'Fri'")
    List<Standplads> find(String keyword);

}
