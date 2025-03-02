package com.spring.rubrica.DTO;

public class nomeEAnnoCreazioneDTO {
	String nome;
	Integer annoCreazione;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAnnoCreazione() {
		return annoCreazione;
	}
	public void setAnnoCreazione(Integer annoCreazione) {
		this.annoCreazione = annoCreazione;
	}
	public nomeEAnnoCreazioneDTO(String nome, Integer annoCreazione) {
		super();
		this.nome = nome;
		this.annoCreazione = annoCreazione;
	}
	public nomeEAnnoCreazioneDTO() {
		super();
	}
	
}
