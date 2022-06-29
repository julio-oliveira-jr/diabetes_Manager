package com.juliooliveirajr.diabetescontrol.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juliooliveirajr.diabetescontrol.entity.AlimentaryBolus;
import com.juliooliveirajr.diabetescontrol.entity.CorrectionBolus;
import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculation;
import com.juliooliveirajr.diabetescontrol.repository.IInsulinCalculationRepositoy;

@Service
public class InsulinCalculationService {
	
	//REPOSITORIES
	@Autowired
	private IInsulinCalculationRepositoy repository;
	
	//SERVICES
	private AlimentaryBolusService alimentaryBolusService;
	private CorrectionBolusService correctionBolusService;
	
	//CRUD
	public InsulinCalculation save(InsulinCalculation entity) {
		if(entity.getRegisterDate() == null) {
			entity.setRegisterDate(LocalDateTime.now());
		}
		entity = this.calculate(entity);
		
		alimentaryBolusService.save(entity.getAlimentaryBolus());
		correctionBolusService.save(entity.getCorrectionBolus());
		
		return repository.save(entity);
	}
	
	public InsulinCalculation update(InsulinCalculation entity) {
		if(has(entity.getInsulinCalculationId())) {
			entity.setModifiedDate(LocalDateTime.now());
			return repository.save(entity);
		}
		
		return null;
	}
	
	public InsulinCalculation search(Integer id) {
		return has(id) ? repository.findById(id).get() : null;
	}
	
	public void delete(Integer id) {
		if(has(id)) {
			alimentaryBolusService.delete(id);
			correctionBolusService.delete(id);
			repository.deleteById(id);
		}
	}
	
	public boolean has(Integer id) {
		return id != null && !repository.findById(id).isEmpty();
	}
	
	public InsulinCalculation calculate(InsulinCalculation insulinCalculation) {
		AlimentaryBolus alimentaryBolus = alimentaryBolusService.calculate(insulinCalculation.getAlimentaryBolus());
		CorrectionBolus correctionBolus = correctionBolusService.calculate(insulinCalculation.getCorrectionBolus());
		
		insulinCalculation.setResultValue(alimentaryBolus.getResultValue().add(correctionBolus.getResultValue()));
		
		return insulinCalculation;
	}
}
