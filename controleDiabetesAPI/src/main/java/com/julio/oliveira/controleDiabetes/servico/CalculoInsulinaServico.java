package com.julio.oliveira.controleDiabetes.servico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.oliveira.controleDiabetes.entidade.CalculoInsulina;
import com.julio.oliveira.controleDiabetes.repositorio.ICalculoInsulinaRepositorio;

@Service
public class CalculoInsulinaServico {
	
	//REPOSITORIOS
	@Autowired
	private ICalculoInsulinaRepositorio repositorio;
	
	//CRUD
	public CalculoInsulina salvar(CalculoInsulina calculoInsulina) {
		if(calculoInsulina.getDatCadastro() == null) {
			calculoInsulina.setDatCadastro(LocalDateTime.now());
		}
		return repositorio.save(calculoInsulina);
	}
	
	public CalculoInsulina atualizar(CalculoInsulina calculoInsulina) {
		if(temCalculoInsulina(calculoInsulina.getCodCalculoInsulina())) {
			calculoInsulina.setDatAlteracao(LocalDateTime.now());
			return repositorio.save(calculoInsulina);
		}
		
		return null;
	}
	
	public CalculoInsulina buscarCalculoInsulina(Integer codCalculoInsulina) {
		return temCalculoInsulina(codCalculoInsulina) ? null : repositorio.findById(codCalculoInsulina).get();
	}
	
	public void excluir(Integer codCalculoInsulina) {
		if(temCalculoInsulina(codCalculoInsulina)) {
			repositorio.deleteById(codCalculoInsulina);
		}
	}
	
	public boolean temCalculoInsulina(Integer codCalculoInsulina) {
		return codCalculoInsulina != null && !repositorio.findById(codCalculoInsulina).isEmpty();
	}
}
