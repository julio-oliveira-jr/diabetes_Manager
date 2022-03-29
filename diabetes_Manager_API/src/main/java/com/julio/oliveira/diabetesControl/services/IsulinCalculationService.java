package com.julio.oliveira.diabetesControl.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.oliveira.diabetesControl.entity.InsulinCalculation;
import com.julio.oliveira.diabetesControl.repository.IInsulinCalculationRepositoy;

@Service
public class IsulinCalculationService {
	
	//REPOSITORIES
	@Autowired
	private IInsulinCalculationRepositoy repository;
	
	//CRUD
	public InsulinCalculation save(InsulinCalculation calculoInsulina) {
		if(calculoInsulina.getRegisterDate() == null) {
			calculoInsulina.setRegisterDate(LocalDateTime.now());
		}
		return repository.save(calculoInsulina);
	}
	
	public InsulinCalculation update(InsulinCalculation calculoInsulina) {
		if(temCalculoInsulina(calculoInsulina.getInsulinCalculationId())) {
			calculoInsulina.setLastUpdateDate(LocalDateTime.now());
			return repository.save(calculoInsulina);
		}
		
		return null;
	}
	
	public InsulinCalculation buscarCalculoInsulina(Integer codCalculoInsulina) {
		return temCalculoInsulina(codCalculoInsulina) ? null : repository.findById(codCalculoInsulina).get();
	}
	
	public void excluir(Integer codCalculoInsulina) {
		if(temCalculoInsulina(codCalculoInsulina)) {
			repository.deleteById(codCalculoInsulina);
		}
	}
	
	public boolean temCalculoInsulina(Integer codCalculoInsulina) {
		return codCalculoInsulina != null && !repository.findById(codCalculoInsulina).isEmpty();
	}
}
