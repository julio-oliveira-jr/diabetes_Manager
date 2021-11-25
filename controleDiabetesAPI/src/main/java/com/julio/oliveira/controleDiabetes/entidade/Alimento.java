package com.julio.oliveira.controleDiabetes.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.julio.oliveira.controleDiabetes.utils.StringUtils;

@Entity
@Inheritance
public class Alimento extends EntidadeBase {
	
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
	private BigDecimal qtdCarboidrato;
	
	@Column(name="QTD_ALIMENTO")
	@NotNull
	private BigDecimal qtdAlimento;
	
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
		this.desResumida = StringUtils.ehStringVaziaOuNull(desResumida) ? desResumida.substring(0, 24) : desResumida;
	}

	public String getDesCompleta() {
		return desCompleta;
	}

	public void setDesCompleta(String desCompleta) {
		this.desCompleta = desCompleta;
	}

	public BigDecimal getQtdCarbouidrato() {
		return qtdCarboidrato;
	}

	public void setQtdCarbouidrato(BigDecimal qtdCarbouidrato) {
		this.qtdCarboidrato = qtdCarbouidrato;
	}

	public BigDecimal getQtdCarboidrato() {
		return qtdCarboidrato;
	}

	public void setQtdCarboidrato(BigDecimal qtdCarboidrato) {
		this.qtdCarboidrato = qtdCarboidrato;
	}

	public BigDecimal getQtdAlimento() {
		return qtdAlimento;
	}

	public void setQtdAlimento(BigDecimal qtdAlimento) {
		this.qtdAlimento = qtdAlimento;
	}

	public BigDecimal getQtdCarboidratoGrama() {
		return qtdCarboidratoGrama;
	}

	public void setQtdCarboidratoGrama(BigDecimal qtdCarboidratoGrama) {
		this.qtdCarboidratoGrama = qtdCarboidratoGrama;
	}

	//HASHCODE E EQUALS
}
