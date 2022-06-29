package com.juliooliveirajr.diabetescontrol.enums;

public enum MealTypeEnum {
	//DECLARATIONS
	BREAKFAST("Café da manhã", "B"),
	LUNCH ("Almoço", "L"),
	DINNER("Jantar","D"),
	SNACK("Lanche", "S");
	
	//CONSTRUCTOR
	MealTypeEnum(String description, String value) {
		this.description = description;
		this.value = value;
	}
	
	//ATTRIBUTES
	private String description;
	private String value;
	
	//GETTERS AND SETTERS
	public String getDescription() {
		return this.description;
	}
	
	public String getValue() {
		return this.value;
	}
}

