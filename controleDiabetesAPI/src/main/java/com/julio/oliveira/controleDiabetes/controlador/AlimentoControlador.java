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

import com.julio.oliveira.controleDiabetes.entidade.Alimento;
import com.julio.oliveira.controleDiabetes.servico.AlimentoServico;

@RestController
@RequestMapping("/alimento")
public class AlimentoControlador {
	//SERVICOS
	@Autowired
	private AlimentoServico servico;
	
	@PostMapping()
	public Alimento salvar(@RequestBody Alimento alimento) {
		return servico.salvar(alimento);
	}
	
	@PutMapping()
	public Alimento atualizar(@RequestBody  Alimento alimento){
		return servico.atualizar(alimento);
	}
	
	@GetMapping("/buscarAlimento/{codAlimento}")
	public Alimento buscarAlimento(@PathVariable Integer codAlimento) {
		return servico.buscarAlimento(codAlimento);
	}
	
	@DeleteMapping("/{codAlimento}")
	public void excluirAlimento(@PathVariable Integer codAlimento) {
		servico.excluir(codAlimento);
	}
	
	
}
