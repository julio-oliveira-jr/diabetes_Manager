package com.juliooliveirajr.diabetescontrol.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity(name = "MeasureUnity")
@Table(name = "MEASURE_UNITY")
public class MeasureUnity extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="MEASURE_UNITY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer measureUnityId;
	
	@Column(name="DESCRIPTION")
	@NotBlank
	private String description;
	
	@Column(name="SYMBOL")
	@NotBlank
	private String symbol;
	
	//CONSTRUCTORS
	public MeasureUnity() {
	}
	
	//GETTERS AND SETTERS
	public MeasureUnity(Integer measureUnityId) {
		this.measureUnityId = measureUnityId;
	}

	public Integer getMeasureUnityId() {
		return measureUnityId;
	}

	public void setMeasureUnityId(Integer measureUnityId) {
		this.measureUnityId = measureUnityId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description, symbol);
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
		if (!(obj instanceof MeasureUnity)) {
			return false;
		}
		MeasureUnity other = (MeasureUnity) obj;
		return Objects.equals(description, other.description) && Objects.equals(symbol, other.symbol);
	}
}
