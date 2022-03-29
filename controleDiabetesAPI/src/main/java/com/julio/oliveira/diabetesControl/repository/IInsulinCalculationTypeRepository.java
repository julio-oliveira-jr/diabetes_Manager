package com.julio.oliveira.diabetesControl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julio.oliveira.diabetesControl.entity.InsulinCalculationType;

@Repository
public interface IInsulinCalculationTypeRepository extends JpaRepository<InsulinCalculationType, Integer> { 
}
