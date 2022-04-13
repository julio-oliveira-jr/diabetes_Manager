package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculation;
import com.juliooliveirajr.diabetescontrol.repository.IInsulinCalculationRepositoy;

@Service
public class IsulinCalculationService {
	
	//REPOSITORIES
	@Autowired
	private IInsulinCalculationRepositoy repository;
	
	//CRUD
	public InsulinCalculation save(InsulinCalculation entity) {
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		return repository.save(entity);
	}
	
	public InsulinCalculation update(InsulinCalculation entity) {
		if(has(entity.getInsulinCalculationId())) {
			entity.setLastUpdateDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public InsulinCalculation search(Integer id) {
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
	
	public InsulinCalculation calculate(InsulinCalculation id) {
		return null;
	}
}
