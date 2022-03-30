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
	private IInsulinCalculationTypeRepository repositorio;
	
	//CRUD
	public InsulinCalculationType save(InsulinCalculationType tipoCalculoInsulina) {
		if(tipoCalculoInsulina.getRegisterDate() == null) {
			tipoCalculoInsulina.setRegisterDate(LocalDateTime.now());
		}
		return repositorio.save(tipoCalculoInsulina);
	}
	
	public InsulinCalculationType update(InsulinCalculationType tipoCalculoInsulina) {
		if(has(tipoCalculoInsulina.getInsulinCalculationTypeId())) {
			tipoCalculoInsulina.setLastUpdateDate(LocalDateTime.now());
			return repositorio.save(tipoCalculoInsulina);
		}
		
		return null;
	}
	
	public InsulinCalculationType search(Integer codTipoCalculoInsulina) {
		return has(codTipoCalculoInsulina) ? null : repositorio.findById(codTipoCalculoInsulina).get();
	}
	
	public void delete(Integer codTipoCalculoInsulina) {
		if(has(codTipoCalculoInsulina)) {
			repositorio.deleteById(codTipoCalculoInsulina);
		}
	}
	
	public boolean has(Integer codTipoCalculoInsulina) {
		return codTipoCalculoInsulina != null && !repositorio.findById(codTipoCalculoInsulina).isEmpty();
	}
}
