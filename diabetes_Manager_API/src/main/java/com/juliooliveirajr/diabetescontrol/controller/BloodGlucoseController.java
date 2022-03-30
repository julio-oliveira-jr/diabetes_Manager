package com.juliooliveirajr.diabetescontrol.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juliooliveirajr.diabetescontrol.entity.BloodGlucose;
import com.juliooliveirajr.diabetescontrol.services.BloodGlucoseService;

@RestController
@RequestMapping("/glucose")
public class BloodGlucoseController {
	//SERVICOS
	@Autowired
	private BloodGlucoseService service;
	
	@PostMapping()
	public BloodGlucose save(@RequestBody BloodGlucose glucose) throws Exception {
		return service.save(glucose);
	}
	
	@PutMapping()
	public BloodGlucose update(@RequestBody  BloodGlucose glucose){
		return service.update(glucose);
	}
	
	@GetMapping("/search/{id}")
	public BloodGlucose search(@PathVariable Integer id) {
		return service.search(id);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<BloodGlucose>> search(@RequestParam(value="from", required = false) LocalDateTime from, @RequestParam(value="to", required = false) LocalDateTime to) {
		return ResponseEntity.ok(service.searchForPeriod(from, to));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
