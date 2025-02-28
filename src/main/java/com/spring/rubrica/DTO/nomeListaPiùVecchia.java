package com.spring.rubrica.DTO;


public class nomeListaPiùVecchia {
	String nome;
	int anno;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getOld() {
		return anno;
	}
	public void setOld(int anno) {
		this.anno = anno;
	}
	public nomeListaPiùVecchia(String nome, int anno) {
		super();
		this.nome = nome;
		this.anno = anno;
	}
	public nomeListaPiùVecchia() {
		super();
	}
	
	
	
}
