package com.juliooliveirajr.diabetescontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.MeasureUnity;

@Repository
public interface IMeasureUnityRepository extends JpaRepository<MeasureUnity, Integer> {
}
