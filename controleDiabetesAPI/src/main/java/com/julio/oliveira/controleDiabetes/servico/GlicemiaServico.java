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
	public Glicemia salvar(Glicemia glicemia) throws Exception{
		if(glicemia.getDatCadastro() == null) {
			glicemia.setDatCadastro(LocalDateTime.now());
		}
		
		this.validar(glicemia);
		
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
	
	public void validar(Glicemia glicemia) throws Exception{
		if(this.existeGlicemia(glicemia)) {
			throw new Exception("Já existe uma glicemia cadastrada com o horário e data informados!");
		}
	}
	
	public boolean existeGlicemia(Glicemia glicemia) {
		return !repositorio.buscarPorDataHorario(glicemia.getDatGlicemia(), glicemia.getHrGlicemia()).isEmpty();
	}
}
