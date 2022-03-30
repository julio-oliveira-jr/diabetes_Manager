package com.juliooliveirajr.diabetescontrol.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.juliooliveirajr.diabetescontrol.utils.StringUtils;

@Entity
@Inheritance
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
	
	@Column(name="CARBOHYDRATE_QTY")
	@NotNull
	private BigDecimal carbohydrateQty;
	
	@Column(name="FOOD_QTY")
	@NotNull
	private BigDecimal foodQty;
	
	@Column(name="CARBOHYDRATE_GRAM_QTY")
	@NotNull
	private BigDecimal carbohydrateGramQty;
	
	//CONSTRUCTOR
	public Food() {
	}

	public Food(Integer foodId) {
		this.foodId = foodId;
	}
	
	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCarbohydrateQty() {
		return carbohydrateQty;
	}

	public void setCarbohydrateQty(BigDecimal carbohydrateQty) {
		this.carbohydrateQty = carbohydrateQty;
	}

	public BigDecimal getFoodQty() {
		return foodQty;
	}

	public void setFoodQty(BigDecimal foodQty) {
		this.foodQty = foodQty;
	}

	public BigDecimal getCarbohydrateGramQty() {
		return carbohydrateGramQty;
	}

	public void setCarbohydrateGramQty(BigDecimal carbohydrateGramQty) {
		this.carbohydrateGramQty = carbohydrateGramQty;
	}

	public String getSummaryDescription() {
		return summaryDescription;
	}

	public void setSummaryDescription(String summaryDescription) {
		this.summaryDescription = StringUtils.isEmptyOrNull(summaryDescription) ? this.description.substring(0, 24) : summaryDescription;
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
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(description, other.description);
	}	
}
