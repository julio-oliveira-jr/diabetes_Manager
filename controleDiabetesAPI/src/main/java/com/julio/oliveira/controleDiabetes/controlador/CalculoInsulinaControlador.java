package com.julio.oliveira.controleDiabetes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julio.oliveira.controleDiabetes.entidade.CalculoInsulina;
import com.julio.oliveira.controleDiabetes.servico.CalculoInsulinaServico;

@RestController
@RequestMapping("/calculoInsulina")
public class CalculoInsulinaControlador {
	//SERVICOS
	@Autowired
	private CalculoInsulinaServico servico;
	
	@PostMapping()
	public CalculoInsulina salvar(@RequestBody CalculoInsulina calculoInsulina) {
		return servico.salvar(calculoInsulina);
	}
	
	@PutMapping()
	public CalculoInsulina atualizar(@RequestBody  CalculoInsulina calculoInsulina){
		return servico.atualizar(calculoInsulina);
	}
	
	@GetMapping("/buscarCalculoInsulina/{codCalculoInsulina}")
	public CalculoInsulina buscarCalculoInsulina(@PathVariable Integer codCalculoInsulina) {
		return servico.buscarCalculoInsulina(codCalculoInsulina);
	}
	
	@DeleteMapping("/{codCalculoInsulina}")
	public void excluirCalculoInsulina(@PathVariable Integer codCalculoInsulina) {
		servico.excluir(codCalculoInsulina);
	}
	
	
}
