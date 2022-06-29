package com.juliooliveirajr.diabetescontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculationType;

@Repository
public interface IInsulinCalculationTypeRepository extends JpaRepository<InsulinCalculationType, Integer> { 
	@Query(nativeQuery = true, value="SELECT * FROM INSULIN_CALCULATION I WHERE I.MEAL_TYPE_IND :filter")
	public List<InsulinCalculationType> searchByFilter(String filter);
}

