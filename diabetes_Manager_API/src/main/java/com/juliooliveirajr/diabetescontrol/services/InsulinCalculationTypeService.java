package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculationType;
import com.juliooliveirajr.diabetescontrol.repository.IInsulinCalculationTypeRepository;

@Service
public class InsulinCalculationTypeService {
	
	//REPOSITORIES
	@Autowired
	private IInsulinCalculationTypeRepository repository;
	
	//CRUD
	public InsulinCalculationType save(InsulinCalculationType entity) {
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		return repository.save(entity);
	}
	
	public InsulinCalculationType update(InsulinCalculationType entity) {
		if(has(entity.getInsulinCalculationTypeId())) {
			entity.setLastUpdateDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public InsulinCalculationType search(Integer id) {
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
