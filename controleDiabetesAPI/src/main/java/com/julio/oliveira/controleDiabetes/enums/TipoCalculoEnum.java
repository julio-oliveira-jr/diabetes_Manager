package com.julio.oliveira.controleDiabetes.enums;

public enum TipoCalculoEnum {
	// DECLARACOES
	BOLUS_CORRECAO("Bolus Correção", "C"),
	BOLUS_ALIMENTACAO("Bolus Alimentação", "A");
	
	// CONSTRUTOR
	TipoCalculoEnum(String descricao, String valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	// ATRIBUTOS
	private String descricao;
	private String valor;
	
	// GETTERS E SETTERS
	public String getDescricao(String valor) {
		return TipoCalculoEnum.valueOf(TipoCalculoEnum.class, valor).descricao;
	}
	
	public String getValor(String descricao) {
		return TipoCalculoEnum.valueOf(TipoCalculoEnum.class, descricao).valor;
	}
}
