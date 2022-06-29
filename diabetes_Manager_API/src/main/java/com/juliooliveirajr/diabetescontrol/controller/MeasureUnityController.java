package com.juliooliveirajr.diabetescontrol.controller;

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

import com.juliooliveirajr.diabetescontrol.entity.MeasureUnity;
import com.juliooliveirajr.diabetescontrol.services.MeasureUnityService;

@RestController
@RequestMapping("/measureUnity")
public class MeasureUnityController {
	//SERVICOS
	@Autowired
	private MeasureUnityService service;
	
	@PostMapping()
	public ResponseEntity<MeasureUnity> save(@RequestBody MeasureUnity entity) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
	
	@PutMapping()
	public ResponseEntity<MeasureUnity> update(@RequestBody MeasureUnity entity){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.update(entity));
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<MeasureUnity> search(@PathVariable Integer id) {
		return ResponseEntity.ok(service.search(id));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
