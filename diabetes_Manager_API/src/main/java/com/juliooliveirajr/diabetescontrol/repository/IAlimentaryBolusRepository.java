package com.juliooliveirajr.diabetescontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.AlimentaryBolus;

@Repository
public interface IAlimentaryBolusRepository extends JpaRepository<AlimentaryBolus, Integer> { 
}
