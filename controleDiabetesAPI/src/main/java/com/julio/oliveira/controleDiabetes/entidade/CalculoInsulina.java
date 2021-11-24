package com.julio.oliveira.controleDiabetes.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CalculoInsulina extends EntidadeBase {
	
	//TODO COLOCAR OS MAPEAMENTOS COMUNS EM UMA ENTIDADE BASE
	
	//MAPEAMENTO
	@Id
	@Column(name="COD_CALCULO_INSULINA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer codCalculoInsulina;
	
	@ManyToOne()
	@JoinColumn(name="COD_TIPO_CALCULO_INSULINA")
	@NotNull
	private TipoCalculoInsulina tipoCalculoInsulina;
	
	@ManyToOne()
	@JoinColumn(name="COD_GLICEMIA")
	@NotNull
	private Glicemia glicemia;
	
	@ManyToOne()
	@JoinColumn(name="COD_ALIMENTO")
	@NotNull
	private Alimento alimento;
	
	@Column(name="VLR_RESULTADO")
	@NotNull
	private BigDecimal vlrResultado;
	
	//CONSTRUTORES
	public CalculoInsulina() {
	}

	public CalculoInsulina(Integer codCalculoInsulina) {
		this.codCalculoInsulina = codCalculoInsulina;
	}
	
	//GETTER E SETTER
	public Integer getCodCalculoInsulina() {
		return codCalculoInsulina;
	}

	public void setCodCalculoInsulina(Integer codCalculoInsulina) {
		this.codCalculoInsulina = codCalculoInsulina;
	}

	public TipoCalculoInsulina getTipoCalculoInsulina() {
		return tipoCalculoInsulina;
	}

	public void setTipoCalculoInsulina(TipoCalculoInsulina tipoCalculoInsulina) {
		this.tipoCalculoInsulina = tipoCalculoInsulina;
	}

	public Glicemia getGlicemia() {
		return glicemia;
	}

	public void setGlicemia(Glicemia glicemia) {
		this.glicemia = glicemia;
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public BigDecimal getVlrResultado() {
		return vlrResultado;
	}

	public void setVlrResultado(BigDecimal vlrResultado) {
		this.vlrResultado = vlrResultado;
	}

	//HASHCODE E EQUALS
}
