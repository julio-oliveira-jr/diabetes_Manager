package com.juliooliveirajr.diabetescontrol.controller;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juliooliveirajr.diabetescontrol.entity.BloodGlucose;
import com.juliooliveirajr.diabetescontrol.services.BloodGlucoseService;

@RestController
@RequestMapping("/bloodGlucose")
public class BloodGlucoseController {
	//SERVICOS
	@Autowired
	private BloodGlucoseService service;
	
	@PostMapping()
	public ResponseEntity<BloodGlucose> save(@RequestBody BloodGlucose entity) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
	
	@PutMapping()
	public ResponseEntity<BloodGlucose> update(@RequestBody BloodGlucose entity){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(entity));
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<BloodGlucose> search(@PathVariable Integer id) {
		return ResponseEntity.ok(service.search(id));
	}
	
	@GetMapping("/searchByPeriod")
	public ResponseEntity<List<BloodGlucose>> search(@RequestParam(value="from", required = false) LocalDateTime from, @RequestParam(value="to", required = false) LocalDateTime to) {
		return ResponseEntity.ok(service.searchForPeriod(from, to));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<BloodGlucose>> search() {
		return ResponseEntity.ok(service.searchForPeriod(LocalDateTime.now().minusDays(1), LocalDateTime.now()));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
