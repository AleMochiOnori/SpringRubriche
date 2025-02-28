package com.spring.rubrica.DTO;

import java.util.ArrayList;
import java.util.List;

public class RubricaDTO {
	int id;
    String nomePropietario;
    String annoDiCreazione;
    List<ContattoDTO> listaContatti; 

    public RubricaDTO(int id , String nomePropietario, String annoDiCreazione) {
    	this.id = id;
        this.nomePropietario = nomePropietario;
        this.annoDiCreazione = annoDiCreazione;
        this.listaContatti = new ArrayList<>();
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


	public String getAnnoDiCreazione() {
		return annoDiCreazione;
	}


	public void setAnnoDiCreazione(String annoDiCreazione) {
		this.annoDiCreazione = annoDiCreazione;
	}

	public List<String> getListaContatti() {
		return listaContatti;
	}

	public void setListaContatti(List<String> listaContatti) {
		this.listaContatti = listaContatti;
	}
	
	
	
	
}
