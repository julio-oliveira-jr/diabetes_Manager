package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.Food;
import com.juliooliveirajr.diabetescontrol.repository.IFoodRepository;

@Service
public class FoodService {
	
	//REPOSITORIES
	@Autowired
	private IFoodRepository repositorio;
	
	//CRUD
	public Food save(Food food) {
		if(food.getRegisterDate() == null) {
			food.setRegisterDate(LocalDateTime.now());
		}
		return repositorio.save(food);
	}
	
	public Food update(Food food) {
		if(has(food.getFoodId())) {
			food.setLastUpdateDate(LocalDateTime.now());
			return repositorio.save(food);
		}
		
		return null;
	}
	
	public Food search(Integer codAlimento) {
		return has(codAlimento) ? null : repositorio.findById(codAlimento).get();
	}
	
	public void delete(Integer codAlimento) {
		if(has(codAlimento)) {
			repositorio.deleteById(codAlimento);
		}
	}
	
	public boolean has(Integer codAlimento) {
		return codAlimento != null && !repositorio.findById(codAlimento).isEmpty();
	}
}
