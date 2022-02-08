package com.julio.oliveira.controleDiabetes.controlador;

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

import com.julio.oliveira.controleDiabetes.entidade.Glicemia;
import com.julio.oliveira.controleDiabetes.servico.GlicemiaServico;

@RestController
@RequestMapping("/glicemia")
public class GlicemiaControlador {
	//SERVICOS
	@Autowired
	private GlicemiaServico servico;
	
	@PostMapping()
	public Glicemia salvar(@RequestBody Glicemia glicemia) throws Exception {
		return servico.salvar(glicemia);
	}
	
	@PutMapping()
	public Glicemia atualizar(@RequestBody  Glicemia glicemia){
		return servico.atualizar(glicemia);
	}
	
	@GetMapping("/buscarGlicemia/{codGlicemia}")
	public Glicemia buscarGlicemia(@PathVariable Integer codGlicemia) {
		return servico.buscarGlicemia(codGlicemia);
	}
	
	@GetMapping("/buscarGlicemias")
	public ResponseEntity<List<Glicemia>> buscarGlicemias(@RequestParam(value="datLimInf", required = false) LocalDateTime datLimInf, @RequestParam(value="datLimSup", required = false) LocalDateTime datLimSup) {
		return ResponseEntity.ok(servico.buscarGlicemias(datLimInf, datLimSup));
	}
	
	@DeleteMapping("/{codGlicemia}")
	public void excluirGlicemia(@PathVariable Integer codGlicemia) {
		servico.excluir(codGlicemia);
	}
}
