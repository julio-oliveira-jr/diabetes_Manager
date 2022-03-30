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
	public BloodGlucose save(BloodGlucose glucose) throws Exception{
		if(glucose.getRegisterDate() == null) {
			glucose.setRegisterDate(LocalDateTime.now());
		}
		
		this.validate(glucose);
		
		return repository.save(glucose);
	}
	
	public BloodGlucose update(BloodGlucose glucose) {
		if(has(glucose.getGlucoseValue())) {
			glucose.setLastUpdateDate(LocalDateTime.now());
			return repository.save(glucose);
		}
		
		return null;
	}
	
	public BloodGlucose search(Integer glucoseId) {
		return has(glucoseId) ? null : repository.findById(glucoseId).get();
	}
	
	public List<BloodGlucose> searchForPeriod(LocalDateTime inferiorLimitDate, LocalDateTime superiorLimitDate) {
		return (inferiorLimitDate == null && superiorLimitDate == null) ? this.searchForWeek() : repository.searchForPeriod(inferiorLimitDate, superiorLimitDate);
	}
	
	public List<BloodGlucose> searchForWeek(){
		return repository.searchForWeek(LocalDateTime.now().plusDays(1), LocalDateTime.now().minusDays(7));
	}
	
	public void delete(Integer glucoseId) {
		if(has(glucoseId)) {
			repository.deleteById(glucoseId);
		}
	}
	
	public boolean has(Integer glucoseId) {
		return glucoseId != null && !repository.findById(glucoseId).isEmpty();
	}
	
	public void validate(BloodGlucose glucose) throws Exception{
		if(this.exists(glucose)) {
			throw new Exception("Já existe uma glucose cadastrada com o horário e data informados!");
		}
	}
	
	public boolean exists(BloodGlucose glucose) {
		return !repository.searchForDateHour(glucose.getGlucoseDate(), glucose.getGlucoseHour()).isEmpty();
	}
}
