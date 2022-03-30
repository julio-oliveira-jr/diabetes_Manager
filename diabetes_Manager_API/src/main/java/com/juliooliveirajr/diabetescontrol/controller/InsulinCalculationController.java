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

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculation;
import com.juliooliveirajr.diabetescontrol.services.IsulinCalculationService;

@RestController
@RequestMapping("/insulinCalculation")
public class InsulinCalculationController {
	//SERVICOS
	@Autowired
	private IsulinCalculationService service;
	
	@PostMapping()
	public InsulinCalculation save(@RequestBody InsulinCalculation insulinCalculation) {
		return service.save(insulinCalculation);
	}
	
	@PutMapping()
	public InsulinCalculation update(@RequestBody  InsulinCalculation insulinCalculation){
		return service.update(insulinCalculation);
	}
	
	@GetMapping("/search/{id}")
	public InsulinCalculation buscarCalculoInsulina(@PathVariable Integer id) {
		return service.buscarCalculoInsulina(id);
	}
	
	@DeleteMapping("/{id}")
	public void excluirCalculoInsulina(@PathVariable Integer id) {
		service.excluir(id);
	}
}
