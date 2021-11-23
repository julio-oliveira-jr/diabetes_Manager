package com.julio.oliveira.controleDiabetes.entidade;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Glicemia extends ClasseBase {
	
	//TODO COLOCAR OS MAPEAMENTOS COMUNS EM UMA ENTIDADE BASE
	
	//MAPEAMENTO
	@Id
	@Column(name="COD_GLICEMIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer codGlicemia;
	
	@Column(name="VLR_GLICEMIA")
	@NotNull
	private Integer vlrGlicemia;
	
	@Column(name="DAT_GLICEMIA")
	@NotNull
	private LocalDateTime datGlicemia;

	//CONSTRUTORES
	public Glicemia() {
	}

	public Glicemia(Integer codGlicemia) {
		this.codGlicemia = codGlicemia;
	}
	
	//GETTER E SETTER
	public Integer getCodGlicemia() {
		return codGlicemia;
	}

	public void setCodGlicemia(Integer codGlicemia) {
		this.codGlicemia = codGlicemia;
	}

	public Integer getVlrGlicemia() {
		return vlrGlicemia;
	}

	public void setVlrGlicemia(Integer vlrGlicemia) {
		this.vlrGlicemia = vlrGlicemia;
	}

	public LocalDateTime getDatGlicemia() {
		return datGlicemia;
	}

	public void setDatGlicemia(LocalDateTime datGlicemia) {
		this.datGlicemia = datGlicemia;
	}
	
	//HASHCODE E EQUALS
}
