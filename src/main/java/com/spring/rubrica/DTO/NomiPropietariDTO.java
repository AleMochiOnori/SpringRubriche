package com.spring.rubrica.DTO;

import java.util.ArrayList;
import java.util.List;

public class NomiPropietariDTO {
	List<String> prop = new ArrayList<>();
	int contatore;
	
	
	
	public NomiPropietariDTO(List<String> prop, int contatore) {
		super();
		this.prop = prop;
		this.contatore = contatore;
	}
	
	public NomiPropietariDTO() {}

	public List<String> getProp() {
		return prop;
	}

	public void setProp(List<String> prop) {
		this.prop = prop;
	}

	public int getContatore() {
		return contatore++;
	}

	public void setContatore(int contatore) {
		this.contatore = contatore;
	};
	
	
	
}
