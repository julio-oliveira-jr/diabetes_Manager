package com.julio.oliveira.diabetesControl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julio.oliveira.diabetesControl.entity.Food;
import com.julio.oliveira.diabetesControl.services.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {
	//SERVICOS
	@Autowired
	private FoodService service;
	
	@PostMapping()
	public Food save(@RequestBody Food food) {
		return service.save(food);
	}
	
	@PutMapping()
	public Food update(@RequestBody  Food food){
		return service.update(food);
	}
	
	@GetMapping("/search/{id}")
	public Food search(@PathVariable Integer id) {
		return service.search(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	
}
