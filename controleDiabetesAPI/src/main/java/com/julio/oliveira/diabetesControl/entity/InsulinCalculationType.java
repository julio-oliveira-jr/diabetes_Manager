package com.julio.oliveira.diabetesControl.entity;

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
public class InsulinCalculationType extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="INSULIN_CALCULATION_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer insulinCalculationTypeId;
	
	@Column(name="CALCULATION_TYPE_IND")
	@NotBlank
	private String calculationTypeInd;
	
	@Column(name="TIME_TYPE_IND")
	@NotBlank
	private String timeTypeInd;
	
	@Column(name="OPTIMAL_GLUCOSE_VALUE")
	@NotNull
	private Integer optimalGlucoseValue;
	
	@Column(name="VARIATION_SENSOR_VALUE")
	@NotNull
	private Integer variationSensorValue;
	
	//CONSTRUCTORS
	public InsulinCalculationType() {
	}

	public InsulinCalculationType(Integer insulinCalculationTypeId) {
		this.insulinCalculationTypeId = insulinCalculationTypeId;
	}
	
	//GETTERS AND SETTERS
	public Integer getInsulinCalculationTypeId() {
		return insulinCalculationTypeId;
	}

	public void setInsulinCalculationTypeId(Integer insulinCalculationTypeId) {
		this.insulinCalculationTypeId = insulinCalculationTypeId;
	}

	public String getCalculationTypeInd() {
		return calculationTypeInd;
	}

	public void setCalculationTypeInd(String calculationTypeInd) {
		this.calculationTypeInd = calculationTypeInd;
	}

	public String getTimeTypeInd() {
		return timeTypeInd;
	}

	public void setTimeTypeInd(String timeTypeInd) {
		this.timeTypeInd = timeTypeInd;
	}

	public Integer getOptimalGlucoseValue() {
		return optimalGlucoseValue;
	}

	public void setOptimalGlucoseValue(Integer optimalGlucoseValue) {
		this.optimalGlucoseValue = optimalGlucoseValue;
	}

	public Integer getVariationSensorValue() {
		return variationSensorValue;
	}

	public void setVariationSensorValue(Integer variationSensorValue) {
		this.variationSensorValue = variationSensorValue;
	}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(calculationTypeInd, optimalGlucoseValue, timeTypeInd, variationSensorValue);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsulinCalculationType other = (InsulinCalculationType) obj;
		return Objects.equals(calculationTypeInd, other.calculationTypeInd)
				&& Objects.equals(optimalGlucoseValue, other.optimalGlucoseValue)
				&& Objects.equals(timeTypeInd, other.timeTypeInd)
				&& Objects.equals(variationSensorValue, other.variationSensorValue);
	}
}
