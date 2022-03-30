package com.juliooliveirajr.diabetescontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculationType;
import com.juliooliveirajr.diabetescontrol.enums.CalculationTypeEnum;
import com.juliooliveirajr.diabetescontrol.enums.TimeTypeEnum;
import com.juliooliveirajr.diabetescontrol.services.InsulinCalculationTypeService;

@RestController
@RequestMapping("/calculationInsulinType")
public class InsulinCalculationTypeController {
	//SERVICOS
	@Autowired
	private InsulinCalculationTypeService service;
	
	@PostMapping()
	public InsulinCalculationType save(@RequestBody InsulinCalculationType insulinCalculationType) {
		return service.save(insulinCalculationType);
	}
	
	@PutMapping()
	public InsulinCalculationType update(@RequestBody  InsulinCalculationType insulinCalculationType){
		return service.update(insulinCalculationType);
	}
	
	@GetMapping("/search/{id}")
	public InsulinCalculationType search(@PathVariable Integer id) {
		return service.search(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluirTipoCalculoInsulina(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@GetMapping("/searchCalculationType")
	public CalculationTypeEnum[] searchCalculationType() {
		return CalculationTypeEnum.values();
	}
	
	@GetMapping("/searchTimeType")
	public TimeTypeEnum[] TimeTypeEnum() {
		return TimeTypeEnum.values();
	}
	
	
}
