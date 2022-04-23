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

@Entity(name = "CorrectionBolus")
@Table(name = "CORRECTION_BOLUS")
public class CorrectionBolus extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="CORRECTION_BOLUS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer corretionBolusId;
	
	@ManyToOne()
	@JoinColumn(name="INSULIN_CALCULATION_TYPE")
	@NotNull
	private InsulinCalculationType insulinCalculationType;
	
	@ManyToOne()
	@JoinColumn(name="GLUCOSE_ID")
	@NotNull
	private BloodGlucose glucose;
	
	@Column(name="RESULT_VALUE")
	@NotNull
	private BigDecimal resultValue;
	
	//CONSTRUCTORS
	public CorrectionBolus() {
	}

	public CorrectionBolus(Integer corretionBolusId) {
		this.corretionBolusId = corretionBolusId;
	}

	//GETTERS AND SETTERS
	public Integer getCorretionBolusId() {
		return corretionBolusId;
	}

	public void setCorretionBolusId(Integer corretionBolusId) {
		this.corretionBolusId = corretionBolusId;
	}

	public InsulinCalculationType getInsulinCalculationType() {
		return insulinCalculationType;
	}

	public void setInsulinCalculationType(InsulinCalculationType insulinCalculationType) {
		this.insulinCalculationType = insulinCalculationType;
	}

	public BloodGlucose getGlucose() {
		return glucose;
	}

	public void setGlucose(BloodGlucose glucose) {
		this.glucose = glucose;
	}

	public BigDecimal getResultValue() {
		return resultValue;
	}

	public void setResultValue(BigDecimal resultValue) {
		this.resultValue = resultValue;
	}
}
