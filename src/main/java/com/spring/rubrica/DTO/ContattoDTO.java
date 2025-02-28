package com.spring.rubrica.DTO;

public class ContattoDTO {
	int id ;
	String nome;
	String cognome;
	int numero;
	String gruppoDiAppartenenza;
	String dataDiNascita;
	boolean isPreferred;
	
	
	
	public ContattoDTO(int id , String nome , String cognome , int numero , String gruppoDiAppartenenza,String dataDiNascita , boolean isPreferred) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoDiAppartenenza = gruppoDiAppartenenza;
		this.dataDiNascita = dataDiNascita;
		this.isPreferred = isPreferred;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getGruppoDiAppartenenza() {
		return gruppoDiAppartenenza;
	}



	public void setGruppoDiAppartenenza(String gruppoDiAppartenenza) {
		this.gruppoDiAppartenenza = gruppoDiAppartenenza;
	}



	public String getDataDiNascita() {
		return dataDiNascita;
	}



	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}



	public boolean isPreferred() {
		return isPreferred;
	}



	public void setPreferred(boolean isPreferred) {
		this.isPreferred = isPreferred;
	}
	
	
	
	
	
	
	
	
}








