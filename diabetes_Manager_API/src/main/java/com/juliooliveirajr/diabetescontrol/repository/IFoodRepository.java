package com.juliooliveirajr.diabetescontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliooliveirajr.diabetescontrol.entity.Food;

@Repository
public interface IFoodRepository extends JpaRepository<Food, Integer> { 
}
