package com.juliooliveirajr.diabetescontrol.services;

import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.Food;
import com.juliooliveirajr.diabetescontrol.repository.IFoodRepository;

@Service
public class FoodService {
	
	//REPOSITORIES
	@Autowired
	private IFoodRepository repository;
	
	//CRUD
	public Food save(Food entity) {
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		entity.setCarbohydrateGramQty(entity.getCarbohydrateQty().divide(entity.getFoodQty(), RoundingMode.HALF_EVEN));
		return repository.save(entity);
	}
	
	public Food update(Food entity) {
		if(has(entity.getFoodId())) {
			entity.setLastUpdateDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public Food search(Integer id) {
		return has(id) ? null : repository.findById(id).get();
	}
	
	public void delete(Integer id) {
		if(has(id)) {
			repository.deleteById(id);
		}
	}
	
	public boolean has(Integer id) {
		return id != null && !repository.findById(id).isEmpty();
	}
}
