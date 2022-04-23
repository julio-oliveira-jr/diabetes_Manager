package com.juliooliveirajr.diabetescontrol.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "InsulinCalculationType")
@Table(name = "INSULIN_CALCULATION_TYPE")
public class InsulinCalculationType extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="INSULIN_CALCULATION_TYPE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer insulinCalculationTypeId;
	
	@Column(name="MEAL_TYPE_IND")
	@NotBlank
	private String mealTypeInd;
	
	@Column(name="OPTIMAL_GLUCOSE_VALUE")
	@NotNull
	private Integer optimalGlucoseValue;
	
	@Column(name="VARIATION_SENSOR_VALUE")
	@NotNull
	private Integer variationSensorValue;
	
	@Column(name="QTY_ CARB_CONS _UNIT_ INSULIN")
	@NotNull
	private Integer qtyCarbConsUnitInsulin;
	
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

	public String getMealTypeInd() {
		return mealTypeInd;
	}

	public void setMealTypeInd(String mealTypeInd) {
		this.mealTypeInd = mealTypeInd;
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
	
	public Integer getQtyCarbConsUnitInsulin() {
		return qtyCarbConsUnitInsulin;
	}

	public void setQtyCarbConsUnitInsulin(Integer qtyCarbConsUnitInsulin) {
		this.qtyCarbConsUnitInsulin = qtyCarbConsUnitInsulin;
	}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mealTypeInd);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof InsulinCalculationType)) {
			return false;
		}
		InsulinCalculationType other = (InsulinCalculationType) obj;
		return Objects.equals(mealTypeInd, other.mealTypeInd);
	}
}
