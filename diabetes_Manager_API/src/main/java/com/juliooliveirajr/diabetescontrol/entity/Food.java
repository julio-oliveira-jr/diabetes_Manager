package com.juliooliveirajr.diabetescontrol.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Food")
@Table(name = "FOOD")
public class Food extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="FOOD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer foodId;
	
	@Column(name="SUMMARY_DESCRIPTION")
	@NotBlank
	private String summaryDescription;
	
	@Column(name="DESCRIPTION")
	@NotBlank
	private String description;
	
	@Column(name="CARBOHYDRATE_QTY_PORTION")
	@NotNull
	private BigDecimal carbohydrateQtyPortion;
	
	@Column(name="UNITY_QTY")
	@NotNull
	private BigDecimal unityQty;
	
	@Column(name="CARBOHYDRATE_QTY_UNITY")
	@NotNull
	private BigDecimal carbohydrateQtyUnity;
	
	@ManyToOne()
	@JoinColumn(name="MEASURE_UNITY_ID")
	@NotNull
	private MeasureUnity measureUnity;
	
	//CONSTRUCTOR
	public Food() {
	}

	public Food(Integer foodId) {
		this.foodId = foodId;
	}
	
	//GETTERS AND SETTERS
	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getSummaryDescription() {
		return summaryDescription;
	}

	public void setSummaryDescription(String summaryDescription) {
		this.summaryDescription = summaryDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCarbohydrateQtyPortion() {
		return carbohydrateQtyPortion;
	}

	public void setCarbohydrateQtyPortion(BigDecimal carbohydrateQtyPortion) {
		this.carbohydrateQtyPortion = carbohydrateQtyPortion;
	}

	public BigDecimal getUnityQty() {
		return unityQty;
	}

	public void setUnityQty(BigDecimal unityQty) {
		this.unityQty = unityQty;
	}

	public BigDecimal getCarbohydrateQtyUnity() {
		return carbohydrateQtyUnity;
	}

	public void setCarbohydrateQtyUnity(BigDecimal carbohydrateQtyUnity) {
		this.carbohydrateQtyUnity = carbohydrateQtyUnity;
	}

	public MeasureUnity getMeasureUnity() {
		return measureUnity;
	}

	public void setMeasureUnity(MeasureUnity measureUnity) {
		this.measureUnity = measureUnity;
	}

	//HASHCODE E EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description);
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
		if (!(obj instanceof Food)) {
			return false;
		}
		Food other = (Food) obj;
		return Objects.equals(description, other.description);
	}
}
