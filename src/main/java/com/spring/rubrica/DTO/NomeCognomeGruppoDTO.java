package com.spring.rubrica.DTO;

public class NomeCognomeGruppoDTO {
	String nome;
	String Cognome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public NomeCognomeGruppoDTO(String nome, String cognome) {
		super();
		this.nome = nome;
		Cognome = cognome;
	}
	public NomeCognomeGruppoDTO() {
		super();
	}
	
}
