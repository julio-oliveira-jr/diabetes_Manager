package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.AlimentaryBolus;
import com.juliooliveirajr.diabetescontrol.repository.IAlimentaryBolusRepository;

@Service
public class AlimentaryBolusService {
	
	//REPOSITORIES
	@Autowired
	private IAlimentaryBolusRepository repository;
	
	//CRUD
	public AlimentaryBolus save(AlimentaryBolus entity) {
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		return repository.save(entity);
	}
	
	public AlimentaryBolus update(AlimentaryBolus entity) {
		if(has(entity.getAlimentaryBolusId())) {
			entity.setLastUpdateDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public AlimentaryBolus search(Integer id) {
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
