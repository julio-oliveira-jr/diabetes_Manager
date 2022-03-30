package com.juliooliveirajr.diabetescontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculationType;

@Repository
public interface IInsulinCalculationTypeRepository extends JpaRepository<InsulinCalculationType, Integer> { 
}
