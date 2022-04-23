package com.juliooliveirajr.diabetescontrol.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "InsulinCalculation")
@Table(name = "INSULIN_CALCULATION")
public class InsulinCalculation extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="INSULIN_CALCULATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer insulinCalculationId;
	
	@Column(name="RESULT_VALUE")
	@NotNull
	private BigDecimal resultValue;
	
	@ManyToOne()
	@JoinColumn(name="ALIMENTARY_BOLUS_ID")
	@NotNull
	private AlimentaryBolus alimentaryBolus;
	
	@ManyToOne()
	@JoinColumn(name="CORRECTION_BOLUS_ID")
	@NotNull
	private CorrectionBolus correctionBolus;
	
	//CONSTRUCTORS
	public InsulinCalculation() {
	}
	
	public InsulinCalculation(Integer insulinCalculationId) {
		this.insulinCalculationId = insulinCalculationId;
	}

	public Integer getInsulinCalculationId() {
		return insulinCalculationId;
	}

	public void setInsulinCalculationId(Integer insulinCalculationId) {
		this.insulinCalculationId = insulinCalculationId;
	}

	public BigDecimal getResultValue() {
		return resultValue;
	}

	public void setResultValue(BigDecimal resultValue) {
		this.resultValue = resultValue;
	}

	public AlimentaryBolus getAlimentaryBolus() {
		return alimentaryBolus;
	}

	public void setAlimentaryBolus(AlimentaryBolus alimentaryBolus) {
		this.alimentaryBolus = alimentaryBolus;
	}

	public CorrectionBolus getCorrectionBolus() {
		return correctionBolus;
	}

	public void setCorrectionBolus(CorrectionBolus correctionBolus) {
		this.correctionBolus = correctionBolus;
	}
}
