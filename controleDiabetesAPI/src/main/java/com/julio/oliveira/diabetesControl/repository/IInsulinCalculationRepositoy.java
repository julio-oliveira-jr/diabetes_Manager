package com.julio.oliveira.diabetesControl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julio.oliveira.diabetesControl.entity.InsulinCalculation;

@Repository
public interface IInsulinCalculationRepositoy extends JpaRepository<InsulinCalculation, Integer> { 
}