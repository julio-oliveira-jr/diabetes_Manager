package com.juliooliveirajr.diabetescontrol.enums;

public enum TimeTypeEnum {
	//DECLARATIONS
	BREAKFAST("Café da manhã", "B"),
	LUNCH ("Almoço", "L"),
	DINNER("Jantar","D"),
	SNACK("Lanche", "S");
	
	//CONSTRUCTOR
	TimeTypeEnum(String description, String value) {
		this.description = description;
		this.value = value;
	}
	
	//ATTRIBUTES
	private String description;
	private String value;
	
	//GETTERS AND SETTERS
	public String getDescricao(String value) {
		return TimeTypeEnum.valueOf(TimeTypeEnum.class, value).description;
	}
	
	public String getValor(String description) {
		return TimeTypeEnum.valueOf(TimeTypeEnum.class, description).value;
	}
	
}

