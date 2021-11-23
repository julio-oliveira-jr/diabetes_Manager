package com.julio.oliveira.controleDiabetes.servico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.oliveira.controleDiabetes.entidade.Alimento;
import com.julio.oliveira.controleDiabetes.repositorio.IAlimentoRepositorio;

@Service
public class AlimentoServico {
	
	//REPOSITORIOS
	@Autowired
	private IAlimentoRepositorio repositorio;
	
	//CRUD
	public Alimento salvar(Alimento alimento) {
		if(alimento.getDatCadastro() == null) {
			alimento.setDatCadastro(LocalDateTime.now());
		}
		return repositorio.save(alimento);
	}
	
	public Alimento atualizar(Alimento alimento) {
		if(temAlimento(alimento.getCodAlimento())) {
			alimento.setDatAlteracao(LocalDateTime.now());
			return repositorio.save(alimento);
		}
		
		return null;
	}
	
	public Alimento buscarAlimento(Integer codAlimento) {
		return temAlimento(codAlimento) ? null : repositorio.findById(codAlimento).get();
	}
	
	public void excluir(Integer codAlimento) {
		if(temAlimento(codAlimento)) {
			repositorio.deleteById(codAlimento);
		}
	}
	
	public boolean temAlimento(Integer codAlimento) {
		return codAlimento != null && !repositorio.findById(codAlimento).isEmpty();
	}
}
