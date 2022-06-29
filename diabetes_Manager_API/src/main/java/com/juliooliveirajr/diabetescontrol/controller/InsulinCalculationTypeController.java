package com.juliooliveirajr.diabetescontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliooliveirajr.diabetescontrol.entity.InsulinCalculationType;
import com.juliooliveirajr.diabetescontrol.enums.MealTypeEnum;
import com.juliooliveirajr.diabetescontrol.services.InsulinCalculationTypeService;

@RestController
@RequestMapping("/calculationInsulinType")
public class InsulinCalculationTypeController {
	//SERVICOS
	@Autowired
	private InsulinCalculationTypeService service;
	
	@PostMapping()
	public ResponseEntity<InsulinCalculationType> save(@RequestBody InsulinCalculationType entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
	
	@PutMapping()
	public ResponseEntity<InsulinCalculationType> update(@RequestBody  InsulinCalculationType entity){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(entity));
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<InsulinCalculationType> search(@PathVariable Integer id) {
		return ResponseEntity.ok(service.search(id));
	}
	
	@GetMapping("/search/{filter}")
	public  ResponseEntity<List<InsulinCalculationType>> searchByFilter(@PathVariable String filter) {
		return ResponseEntity.ok(service.searchByFilter(filter));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@GetMapping("/searchMealType")
	public MealTypeEnum[] MealTypeEnum() {
		return MealTypeEnum.values();
	}
}
