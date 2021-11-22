package com.julio.oliveira.controleDiabetes.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Alimento extends ClasseBase {
	
	//TODO COLOCAR OS MAPEAMENTOS COMUNS EM UMA ENTIDADE BASE
	
	//MAPEAMENTO
	@Id
	@Column(name="COD_ALIMENTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer codAlimento;
	
	@Column(name="DES_RESUMIDA")
	@NotBlank
	private String desResumida;
	
	@Column(name="DES_COMPLETA")
	@NotBlank
	private String desCompleta;
	
	@Column(name="QTD_CARBOIDRATO")
	@NotNull
	private BigDecimal qtdCarbouidrato;
	
	@Column(name="QTD_GRAMA")
	@NotNull
	private BigDecimal qtdGrama;
	
	@Column(name="QTD_CARBOIDRATO__GRAMA")
	@NotNull
	private BigDecimal qtdCarboidratoGrama;
	
	//CONSTRUTORES
	public Alimento() {
	}

	public Alimento(Integer codAlimento) {
		this.codAlimento = codAlimento;
	}
	
	//GETTER E SETTER
	public Integer getCodAlimento() {
		return codAlimento;
	}

	public void setCodAlimento(Integer codAlimento) {
		this.codAlimento = codAlimento;
	}

	public String getDesResumida() {
		return desResumida;
	}

	public void setDesResumida(String desResumida) {
		this.desResumida = desResumida;
	}

	public String getDesCompleta() {
		return desCompleta;
	}

	public void setDesCompleta(String desCompleta) {
		this.desCompleta = desCompleta;
	}

	public BigDecimal getQtdCarbouidrato() {
		return qtdCarbouidrato;
	}

	public void setQtdCarbouidrato(BigDecimal qtdCarbouidrato) {
		this.qtdCarbouidrato = qtdCarbouidrato;
	}

	public BigDecimal getQtdGrama() {
		return qtdGrama;
	}

	public void setQtdGrama(BigDecimal qtdGrama) {
		this.qtdGrama = qtdGrama;
	}

	public BigDecimal getQtdCarboidratoGrama() {
		return qtdCarboidratoGrama;
	}

	public void setQtdCarboidratoGrama(BigDecimal qtdCarboidratoGrama) {
		this.qtdCarboidratoGrama = qtdCarboidratoGrama;
	}

	//HASHCODE E EQUALS
}
