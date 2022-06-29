package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.MeasureUnity;
import com.juliooliveirajr.diabetescontrol.repository.IMeasureUnityRepository;

@Service
public class MeasureUnityService {
	
	//REPOSITORIES
	@Autowired
	private IMeasureUnityRepository repository;
	
	//CRUD
	public MeasureUnity save(MeasureUnity entity) throws Exception{
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		
		return repository.save(entity);
	}
	
	public MeasureUnity update(MeasureUnity entity) {
		if(has(entity.getMeasureUnityId())) {
			entity.setModifiedDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public MeasureUnity search(Integer id) {
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

}
