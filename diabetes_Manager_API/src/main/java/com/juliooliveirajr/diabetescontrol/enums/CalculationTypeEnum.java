package com.juliooliveirajr.diabetescontrol.enums;

public enum CalculationTypeEnum {
	//DECLARATIONS
	CORRECTION_BOLUS("Bolus Correção", "C"),
	MEAL_BOLUS("Bolus Alimentação", "M");
	
	//CONSTRUCTOR
	CalculationTypeEnum(String description, String value) {
		this.description = description;
		this.value = value;
	}
	
	//ATTRIBUTES
	private String description;
	private String value;
	
	//GETTERS AND SETTERS
	public String getDescription(String value) {
		return CalculationTypeEnum.valueOf(CalculationTypeEnum.class, value).description;
	}
	
	public String getValue(String description) {
		return CalculationTypeEnum.valueOf(CalculationTypeEnum.class, description).value;
	}
}
