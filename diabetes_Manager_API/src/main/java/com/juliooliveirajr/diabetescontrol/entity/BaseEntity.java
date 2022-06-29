package com.juliooliveirajr.diabetescontrol.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BaseEntity {
	//MAPPING
	@Column(name="REGISTER_DATE")
	@NotNull
	private LocalDateTime registerDate;
	
	@Column(name="MODIFIED_DATE")
	private LocalDateTime modifiedDate;
	
	@Column(name="USER_ID")
	@NotNull
	private Integer userId;
	
	//GETTERS AND SETTERS
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(registerDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(registerDate, other.registerDate);
	}	
}
