package com.juliooliveirajr.diabetescontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.CorrectionBolus;

@Repository
public interface ICorrectionBolusRepository extends JpaRepository<CorrectionBolus, Integer> { 
}
