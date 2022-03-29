package com.julio.oliveira.diabetesControl.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.oliveira.diabetesControl.entity.Food;
import com.julio.oliveira.diabetesControl.repository.IFoodRepository;

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
