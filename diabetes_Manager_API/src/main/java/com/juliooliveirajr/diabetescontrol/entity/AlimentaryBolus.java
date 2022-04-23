package com.juliooliveirajr.diabetescontrol.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity(name = "AlimentaryBolus")
@Table(name = "ALIMENTARY_BOLUS")
public class AlimentaryBolus extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="ALIMENTARY_BOLUS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer alimentaryBolusId;
	
	@ManyToOne()
	@JoinColumn(name="INSULIN_CALCULATION_TYPE")
	@NotNull
	private InsulinCalculationType insulinCalculationType;
	
	@Column(name="FOODS_IDS")
	private String foodsIds;
	
	@Transient
	private List<Food> foodsList;
	
	@Column(name="RESULT_VALUE")
	@NotNull
	private BigDecimal resultValue;
	
	//CONSTRUCTORS
	public AlimentaryBolus() {
	}

	public AlimentaryBolus(Integer alimentaryBolusId) {
		this.alimentaryBolusId = alimentaryBolusId;
	}

	//GETTERS AND SETTERS 
	public Integer getAlimentaryBolusId() {
		return alimentaryBolusId;
	}

	public void setAlimentaryBolusId(Integer alimentaryBolusId) {
		this.alimentaryBolusId = alimentaryBolusId;
	}

	public InsulinCalculationType getInsulinCalculationType() {
		return insulinCalculationType;
	}

	public void setInsulinCalculationType(InsulinCalculationType insulinCalculationType) {
		this.insulinCalculationType = insulinCalculationType;
	}

	public String getFoodsIds() {
		return foodsIds;
	}

	public void setFoodsIds(String foodsIds) {
		this.foodsIds = foodsIds;
	}

	public List<Food> getFoodsList() {
		return foodsList;
	}

	public void setFoodsList(List<Food> foodsList) {
		this.foodsList = foodsList;
	}

	public BigDecimal getResultValue() {
		return resultValue;
	}

	public void setResultValue(BigDecimal resultValue) {
		this.resultValue = resultValue;
	}
}
