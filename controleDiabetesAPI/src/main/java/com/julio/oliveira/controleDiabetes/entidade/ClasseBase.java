package com.julio.oliveira.controleDiabetes.entidade;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ClasseBase {

	@Column(name="DAT_CADASTRO")
	@NotNull
	private LocalDateTime datCadastro;
	
	@Column(name="DAT_ALTERACAO")
	private LocalDateTime datAlteracao;
	
	@Column(name="USUARIO")
	@NotBlank
	private String usuario;

	public LocalDateTime getDatCadastro() {
		return datCadastro;
	}

	public void setDatCadastro(LocalDateTime datCadastro) {
		this.datCadastro = datCadastro;
	}

	public LocalDateTime getDatAlteracao() {
		return datAlteracao;
	}

	public void setDatAlteracao(LocalDateTime datAlteracao) {
		this.datAlteracao = datAlteracao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
