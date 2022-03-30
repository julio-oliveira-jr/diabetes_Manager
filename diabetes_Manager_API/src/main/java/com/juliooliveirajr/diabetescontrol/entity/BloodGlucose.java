package com.juliooliveirajr.diabetescontrol.entity;

import java.time.LocalDateTime;
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
public class BloodGlucose extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="GLUCOSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer glucoseId;
	
	@Column(name="GLUCOSE_VALUE")
	@NotNull
	private Integer glucoseValue;
	
	@Column(name="GLUCOSE_DATE")
	@NotNull
	private LocalDateTime glucoseDate;
	
	@Column(name="GLUCOSE_HOUR")
	@NotBlank
	private String glucoseHour;
	
	//CONSTRUCTORS
	public BloodGlucose() {
	}

	public BloodGlucose(Integer glucoseId) {
		this.glucoseId = glucoseId;
	}
	
	//GETTERS AND SETTERS
	public Integer getGlucoseId() {
		return glucoseId;
	}

	public void setGlucoseId(Integer glucoseId) {
		this.glucoseId = glucoseId;
	}

	public Integer getGlucoseValue() {
		return glucoseValue;
	}

	public void setGlucoseValue(Integer glucoseValue) {
		this.glucoseValue = glucoseValue;
	}

	public LocalDateTime getGlucoseDate() {
		return glucoseDate;
	}

	public void setGlucoseDate(LocalDateTime glucoseDate) {
		this.glucoseDate = glucoseDate;
	}

	public String getGlucoseHour() {
		return glucoseHour;
	}

	public void setGlucoseHour(String glucoseHour) {
		this.glucoseHour = glucoseHour;
	}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(glucoseDate, glucoseHour);
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
		BloodGlucose other = (BloodGlucose) obj;
		return Objects.equals(glucoseDate, other.glucoseDate) && Objects.equals(glucoseHour, other.glucoseHour);
	}
}
