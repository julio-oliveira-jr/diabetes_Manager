package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.CorrectionBolus;
import com.juliooliveirajr.diabetescontrol.repository.ICorrectionBolusRepository;

@Service
public class CorrectionBolusService {
	
	//REPOSITORIES
	@Autowired
	private ICorrectionBolusRepository repository;
	
	//CRUD
	public CorrectionBolus save(CorrectionBolus entity) {
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		return repository.save(entity);
	}
	
	public CorrectionBolus update(CorrectionBolus entity) {
		if(has(entity.getCorretionBolusId())) {
			entity.setLastUpdateDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public CorrectionBolus search(Integer id) {
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
