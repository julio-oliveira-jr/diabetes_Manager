package com.juliooliveirajr.diabetescontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.Food;

@Repository
public interface IFoodRepository extends JpaRepository<Food, Integer> {
	@Query(nativeQuery = true, value="SELECT * FROM FOOD F WHERE F.FOOD_ID :clause")
	public List<Food> searchByInClause(String clause);
	
	@Query(nativeQuery = true, value="SELECT * FROM FOOD F WHERE F.FOOD_DESCRIPTION LIKE '%:clause%'")
	public List<Food> searchByFilter(String filter);
}
