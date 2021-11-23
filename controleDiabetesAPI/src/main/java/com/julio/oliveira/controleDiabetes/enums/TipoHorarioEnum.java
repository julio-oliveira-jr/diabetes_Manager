package com.julio.oliveira.controleDiabetes.enums;

public enum TipoHorarioEnum {
	// DECLARACOES
	CAFE_MANHA("Café da manhã", "C"),
	ALMOCO("Almoço", "A"),
	JANTAR("JANTAR","J"),
	LANCHE("Lanche", "L");
	
	// CONSTRUTOR
	TipoHorarioEnum(String descricao, String valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	// ATRIBUTOS
	private String descricao;
	private String valor;
	
	// GETTERS E SETTERS
	public String getDescricao(String valor) {
		return TipoHorarioEnum.valueOf(TipoHorarioEnum.class, valor).descricao;
	}
	
	public String getValor(String descricao) {
		return TipoHorarioEnum.valueOf(TipoHorarioEnum.class, valor).valor;
	}
	
}

