package com.julio.oliveira.controleDiabetes.servico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.oliveira.controleDiabetes.entidade.Glicemia;
import com.julio.oliveira.controleDiabetes.repositorio.IGlicemiaRepositorio;

@Service
public class GlicemiaServico {
	
	//REPOSITORIOS
	@Autowired
	private IGlicemiaRepositorio repositorio;
	
	//CRUD
	public Glicemia salvar(Glicemia glicemia) {
		if(glicemia.getDatCadastro() == null) {
			glicemia.setDatCadastro(LocalDateTime.now());
		}
		return repositorio.save(glicemia);
	}
	
	public Glicemia atualizar(Glicemia glicemia) {
		if(temGlicemia(glicemia.getCodGlicemia())) {
			glicemia.setDatAlteracao(LocalDateTime.now());
			return repositorio.save(glicemia);
		}
		
		return null;
	}
	
	public Glicemia buscarGlicemia(Integer codGlicemia) {
		return temGlicemia(codGlicemia) ? null : repositorio.findById(codGlicemia).get();
	}
	
	public void excluir(Integer codGlicemia) {
		if(temGlicemia(codGlicemia)) {
			repositorio.deleteById(codGlicemia);
		}
	}
	
	public boolean temGlicemia(Integer codGlicemia) {
		return codGlicemia != null && !repositorio.findById(codGlicemia).isEmpty();
	}
}
