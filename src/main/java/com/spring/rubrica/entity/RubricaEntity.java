package com.spring.rubrica.entity;

import java.util.ArrayList;
import java.util.List;


public class RubricaEntity {
		int id;
		String nomePropetario;
		int annoDiCreazione;
		List<ContattoEntity> listaContatti = new ArrayList<>(); 
		
		 
		 
		 public RubricaEntity() {
			// TODO Auto-generated constructor stub
		}
		 
		 
		
		public RubricaEntity(int id, String nomePropetario , int annoDiCreazione , List<ContattoEntity> listaContatti) {
			this.id = id;
			this.nomePropetario = nomePropetario;
			this.annoDiCreazione = annoDiCreazione;
			this.listaContatti = listaContatti;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getNomePropetario() {
			return nomePropetario;
		}


		public void setNomePropetario(String nomePropetario) {
			this.nomePropetario = nomePropetario;
		}


		public int getAnnoDiCreazione() {
			return annoDiCreazione;
		}


		public void setAnnoDiCreazione(int annoDiCreazione) {
			this.annoDiCreazione = annoDiCreazione;
		}


		public void setListaContatti(List<ContattoEntity> listaContatti) {
			this.listaContatti = listaContatti;
		}
		
		
		public List<ContattoEntity> getListaContatti() {
			return listaContatti;
		}
		
		
		
}
