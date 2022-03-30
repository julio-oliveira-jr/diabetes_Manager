package com.juliooliveirajr.diabetescontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculation;

@Repository
public interface IInsulinCalculationRepositoy extends JpaRepository<InsulinCalculation, Integer> { 
}
