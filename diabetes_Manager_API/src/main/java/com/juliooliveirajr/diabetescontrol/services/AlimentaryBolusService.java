package com.juliooliveirajr.diabetescontrol.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.AlimentaryBolus;
import com.juliooliveirajr.diabetescontrol.entity.Food;
import com.juliooliveirajr.diabetescontrol.repository.IAlimentaryBolusRepository;

@Service
public class AlimentaryBolusService {
	
	// Inrterface
	interface CarbohydrateCalculation {
	  
	    // Method inside the interface
	    BigDecimal func(BigDecimal number);
	}
	
	//REPOSITORIES
	@Autowired
	private IAlimentaryBolusRepository repository;
	
	//SERVICES
	@Autowired
	private FoodService foodService;
	
	//CRUD
	public AlimentaryBolus save(AlimentaryBolus entity) {
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		return repository.save(entity);
	}
	
	public AlimentaryBolus update(AlimentaryBolus entity) {
		if(has(entity.getAlimentaryBolusId())) {
			entity.setModifiedDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public AlimentaryBolus search(Integer id) {
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
	
	public AlimentaryBolus calculate(AlimentaryBolus alimentaryBolus) {	
		BigDecimal carbohydrate = BigDecimal.ZERO;
		
		CarbohydrateCalculation carbohydrateCalculation = (number) ->
        {
        	alimentaryBolus.getFoodsMap().entrySet().forEach(entry -> {
    			Food food = foodService.search(entry.getKey());
    			
    			number.add(food.getCarbohydrateQtyUnity().multiply(BigDecimal.valueOf(entry.getValue())));
    		});
        	
        	return number;
        };
                   
		alimentaryBolus.setResultValue(carbohydrateCalculation.func(carbohydrate).divide(BigDecimal.valueOf(alimentaryBolus.getInsulinCalculationType().getQtyCarbConsUnitInsulin())));
		
		return alimentaryBolus;
	}
}