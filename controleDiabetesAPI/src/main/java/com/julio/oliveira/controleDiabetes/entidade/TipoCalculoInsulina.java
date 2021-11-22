package com.julio.oliveira.controleDiabetes.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class TipoCalculoInsulina extends ClasseBase {
	
	//TODO COLOCAR OS MAPEAMENTOS COMUNS EM UMA ENTIDADE BASE
	
	//MAPEAMENTO
	@Id
	@Column(name="COD_TIPO_CALCULO_INSULINA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer codTipoCalculoInsulina;
	
	@Column(name="IND_TIPO_CALCULO")
	@NotBlank
	private String indTipoCalculo;
	
	@Column(name="IND_TIPO_HORARIO")
	@NotBlank
	private String indTipoHorario;
	
	@Column(name="VLR_GLICEMIA_IDEAL")
	@NotNull
	private Integer vlrGlicemiaIdeal;
	
	@Column(name="VLR_SENSOR_VARIACAO")
	@NotNull
	private Integer vlrSensorVariacao;
	
	//CONSTRUTORES
	public TipoCalculoInsulina() {
	}

	public TipoCalculoInsulina(Integer codTipoCalculoInsulina) {
		this.codTipoCalculoInsulina = codTipoCalculoInsulina;
	}

	//GETTER E SETTER
	public Integer getCodTipoCalculoInsulina() {
		return codTipoCalculoInsulina;
	}

	public void setCodTipoCalculoInsulina(Integer codTipoCalculoInsulina) {
		this.codTipoCalculoInsulina = codTipoCalculoInsulina;
	}

	public String getIndTipoCalculo() {
		return indTipoCalculo;
	}

	public void setIndTipoCalculo(String indTipoCalculo) {
		this.indTipoCalculo = indTipoCalculo;
	}

	public String getIndTipoHorario() {
		return indTipoHorario;
	}

	public void setIndTipoHorario(String indTipoHorario) {
		this.indTipoHorario = indTipoHorario;
	}

	public Integer getVlrGlicemiaIdeal() {
		return vlrGlicemiaIdeal;
	}

	public void setVlrGlicemiaIdeal(Integer vlrGlicemiaIdeal) {
		this.vlrGlicemiaIdeal = vlrGlicemiaIdeal;
	}

	public Integer getVlrSensorVariacao() {
		return vlrSensorVariacao;
	}

	public void setVlrSensorVariacao(Integer vlrSensorVariacao) {
		this.vlrSensorVariacao = vlrSensorVariacao;
	}

	//HASHCODE E EQUALS
}
