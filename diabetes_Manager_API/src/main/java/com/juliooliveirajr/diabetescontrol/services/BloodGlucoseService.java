package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.BloodGlucose;
import com.juliooliveirajr.diabetescontrol.repository.IBloodGlucoseRepository;

@Service
public class BloodGlucoseService {
	
	//REPOSITORIES
	@Autowired
	private IBloodGlucoseRepository repository;
	
	//CRUD
	public BloodGlucose save(BloodGlucose entity) throws Exception{
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		
		this.validate(entity);
		
		return repository.save(entity);
	}
	
	public BloodGlucose update(BloodGlucose entity) {
		if(has(entity.getGlucoseValue())) {
			entity.setLastUpdateDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public BloodGlucose search(Integer id) {
		return has(id) ? null : repository.findById(id).get();
	}
	
	public List<BloodGlucose> searchForPeriod(LocalDateTime from, LocalDateTime to) {
		return (from == null && to == null) ? this.searchForWeek() : repository.searchForPeriod(from, to);
	}
	
	public List<BloodGlucose> searchForWeek(){
		return repository.searchForWeek(LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(7));
	}
	
	public void delete(Integer id) {
		if(has(id)) {
			repository.deleteById(id);
		}
	}
	
	public boolean has(Integer id) {
		return id != null && !repository.findById(id).isEmpty();
	}
	
	public void validate(BloodGlucose entity) throws Exception{
		if(this.exists(entity)) {
			throw new Exception("Já existe uma glucose cadastrada com o horário e data informados!");
		}
	}
	
	public boolean exists(BloodGlucose entity) {
		return !repository.searchForDateHour(entity.getGlucoseDate(), entity.getGlucoseHour()).isEmpty();
	}
}
