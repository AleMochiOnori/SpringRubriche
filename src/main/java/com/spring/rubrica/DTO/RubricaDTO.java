package com.spring.rubrica.DTO;

import java.util.List;

public class RubricaDTO {
	int id;
    String nomePropietario;
    int annoDiCreazione;
    List<ContattoDTO> listaContatti; 

    public RubricaDTO(int id , String nomePropietario, int annoDiCreazione , List<ContattoDTO> listaContatti ) {
    	this.id = id;
        this.nomePropietario = nomePropietario;
        this.annoDiCreazione = annoDiCreazione;
        this.listaContatti = listaContatti;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomePropietario() {
		return nomePropietario;
	}


	public void setNomePropietario(String nomePropetario) {
		this.nomePropietario = nomePropetario;
	}


	public int getAnnoDiCreazione() {
		return annoDiCreazione;
	}


	public void setAnnoDiCreazione(int annoDiCreazione) {
		this.annoDiCreazione = annoDiCreazione;
	}

	public List<ContattoDTO> getListaContatti() {
		return listaContatti;
	}

	public void setListaContatti(List<ContattoDTO> listaContatti) {
		this.listaContatti = listaContatti;
	}
	
	
	
	
}
