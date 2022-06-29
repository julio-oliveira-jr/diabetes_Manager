package com.juliooliveirajr.diabetescontrol.services;

import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

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
		entity.setCarbohydrateQtyUnity(entity.getCarbohydrateQtyPortion().divide(entity.getUnityQty(), RoundingMode.HALF_EVEN));
		return repository.save(entity);
	}
	
	public Food update(Food entity) {
		if(has(entity.getFoodId())) {
			entity.setModifiedDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public Food search(Integer id) {
		return has(id) ? repository.findById(id).get() : null;
	}
	
	public void delete(Integer id) {
		if(has(id)) {
			repository.deleteById(id);
		}
	}
	
	public boolean has(Integer id) {
		return id != null && !repository.findById(id).isEmpty();
	}
	
	public List<Food> searchByClauseIn(String clause){
		return repository.searchByInClause(clause);
	}
	
	public List<Food> searchByFilter(String filter){
		return repository.searchByFilter(filter);
	}
}
