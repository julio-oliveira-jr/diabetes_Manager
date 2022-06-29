package com.juliooliveirajr.diabetescontrol.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "BloodGlucose")
@Table(name = "BLOOD_GLUCOSE")
public class BloodGlucose extends BaseEntity {
	//MAPPING
	@Id
	@Column(name="BLOOD_GLUCOSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer bloodGlucoseId;
	
	@Column(name="VALUE")
	@NotNull
	private Integer value;
	
	@Column(name="DATE")
	@NotNull
	private LocalDateTime date;
	
	@Column(name="HOUR")
	@NotBlank
	private String hour;
	
	//CONSTRUCTORS
	public BloodGlucose() {
	}

	public Integer getBloodGlucoseId() {
		return bloodGlucoseId;
	}

	//GETTERS AND SETTERS
	public void setBloodGlucoseId(Integer bloodGlucoseId) {
		this.bloodGlucoseId = bloodGlucoseId;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setvalue(Integer value) {
		this.value = value;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		return true;
	}
}
