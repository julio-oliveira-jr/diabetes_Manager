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

import com.julio.oliveira.controleDiabetes.entidade.TipoCalculoInsulina;
import com.julio.oliveira.controleDiabetes.enums.TipoCalculoEnum;
import com.julio.oliveira.controleDiabetes.enums.TipoHorarioEnum;
import com.julio.oliveira.controleDiabetes.servico.TipoCalculoInsulinaServico;

@RestController
@RequestMapping("/tipoCalculoInsulina")
public class TipoCalculoInsulinaControlador {
	//SERVICOS
	@Autowired
	private TipoCalculoInsulinaServico servico;
	
	@PostMapping()
	public TipoCalculoInsulina salvar(@RequestBody TipoCalculoInsulina tipoCalculoInsulina) {
		return servico.salvar(tipoCalculoInsulina);
	}
	
	@PutMapping()
	public TipoCalculoInsulina atualizar(@RequestBody  TipoCalculoInsulina tipoCalculoInsulina){
		return servico.atualizar(tipoCalculoInsulina);
	}
	
	@GetMapping("/buscarTipoCalculoInsulina/{codTipoCalculoInsulina}")
	public TipoCalculoInsulina buscarTipoCalculoInsulina(@PathVariable Integer codTipoCalculoInsulina) {
		return servico.buscarTipoCalculoInsulina(codTipoCalculoInsulina);
	}
	
	@DeleteMapping("/{codTipoCalculoInsulina}")
	public void excluirTipoCalculoInsulina(@PathVariable Integer codTipoCalculoInsulina) {
		servico.excluir(codTipoCalculoInsulina);
	}
	
	@GetMapping("/buscarTipoCalculoEnum")
	public TipoCalculoEnum[] buscarTipoCalculoEnum() {
		return TipoCalculoEnum.values();
	}
	
	@GetMapping("/buscarTipoHorarioEnum")
	public TipoHorarioEnum[] buscarHorarioEnum() {
		return TipoHorarioEnum.values();
	}
	
	
}
