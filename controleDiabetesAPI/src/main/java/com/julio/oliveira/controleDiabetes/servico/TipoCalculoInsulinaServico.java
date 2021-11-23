package com.julio.oliveira.controleDiabetes.servico;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.oliveira.controleDiabetes.entidade.TipoCalculoInsulina;
import com.julio.oliveira.controleDiabetes.repositorio.ITipoCalculoInsulinaRepositorio;

@Service
public class TipoCalculoInsulinaServico {
	
	//REPOSITORIOS
	@Autowired
	private ITipoCalculoInsulinaRepositorio repositorio;
	
	//CRUD
	public TipoCalculoInsulina salvar(TipoCalculoInsulina tipoCalculoInsulina) {
		if(tipoCalculoInsulina.getDatCadastro() == null) {
			tipoCalculoInsulina.setDatCadastro(LocalDateTime.now());
		}
		return repositorio.save(tipoCalculoInsulina);
	}
	
	public TipoCalculoInsulina atualizar(TipoCalculoInsulina tipoCalculoInsulina) {
		if(temCalculoInsulina(tipoCalculoInsulina.getCodTipoCalculoInsulina())) {
			tipoCalculoInsulina.setDatAlteracao(LocalDateTime.now());
			return repositorio.save(tipoCalculoInsulina);
		}
		
		return null;
	}
	
	public TipoCalculoInsulina buscarTipoCalculoInsulina(Integer codTipoCalculoInsulina) {
		return temCalculoInsulina(codTipoCalculoInsulina) ? null : repositorio.findById(codTipoCalculoInsulina).get();
	}
	
	public void excluir(Integer codTipoCalculoInsulina) {
		if(temCalculoInsulina(codTipoCalculoInsulina)) {
			repositorio.deleteById(codTipoCalculoInsulina);
		}
	}
	
	public boolean temCalculoInsulina(Integer codTipoCalculoInsulina) {
		return codTipoCalculoInsulina != null && !repositorio.findById(codTipoCalculoInsulina).isEmpty();
	}
}
