package com.juliooliveirajr.diabetescontrol.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
public class InsulinCalculation extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="INSULIN_CALCULATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer insulinCalculationId;
	
	@ManyToOne()
	@JoinColumn(name="INSULIN_CALCULATION_TYPE")
	@NotNull
	private InsulinCalculationType insulinCalculationType;
	
	@ManyToOne()
	@JoinColumn(name="GLUCOSE_ID")
	@NotNull
	private BloodGlucose glucose;
	
	@ManyToOne()
	@JoinColumn(name="foodId")
	@NotNull
	private Food food;
	
	@Column(name="RESULT_VALUE")
	@NotNull
	private BigDecimal resultValue;
	
	//CONSTRUCTORS
	public InsulinCalculation() {
	}

	public InsulinCalculation(Integer insulinCalculationId) {
		this.insulinCalculationId = insulinCalculationId;
	}
	
	//GETTERS AND SETTERS
	public Integer getInsulinCalculationId() {
		return insulinCalculationId;
	}

	public void setInsulinCalculationId(Integer insulinCalculationId) {
		this.insulinCalculationId = insulinCalculationId;
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

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public BigDecimal getResultValue() {
		return resultValue;
	}

	public void setResultValue(BigDecimal resultValue) {
		this.resultValue = resultValue;
	}
}
