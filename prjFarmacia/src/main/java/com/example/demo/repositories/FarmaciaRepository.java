package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Farmacia;
@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long>{

}
