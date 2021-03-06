package com.julio.oliveira.controleDiabetes.entidade;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
public class Glicemia extends EntidadeBase {
	
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
	
	@Column(name="HR_GLICEMIA")
	@NotBlank
	private String hrGlicemia;
	
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

	public String getHrGlicemia() {
		return hrGlicemia;
	}

	public void setHrGlicemia(String hrGlicemia) {
		this.hrGlicemia = hrGlicemia;
	}
	
	//HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(datGlicemia, hrGlicemia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Glicemia other = (Glicemia) obj;
		return Objects.equals(datGlicemia, other.datGlicemia) && Objects.equals(hrGlicemia, other.hrGlicemia);
	}
}
