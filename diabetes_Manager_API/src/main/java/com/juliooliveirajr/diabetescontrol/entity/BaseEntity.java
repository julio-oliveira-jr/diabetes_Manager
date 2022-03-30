package com.juliooliveirajr.diabetescontrol.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BaseEntity {
	//MAPPING
	@Column(name="REGISTER_DATE")
	@NotNull
	private LocalDateTime registerDate;
	
	@Column(name="LAST_UPDATE_DATE")
	private LocalDateTime lastUpdateDate;
	
	@Column(name="USER")
	@NotBlank
	private String user;
	
	
	//GETTERS AND SETTERS
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(registerDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(registerDate, other.registerDate);
	}
}
