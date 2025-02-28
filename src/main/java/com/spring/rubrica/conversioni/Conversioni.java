package com.spring.rubrica.conversioni;

import com.spring.rubrica.DTO.ContattoDTO;
import com.spring.rubrica.DTO.RubricaDTO;
import com.spring.rubrica.entity.ContattoEntity;
import com.spring.rubrica.entity.RubricaEntity;

public class Conversioni {
	
	
	public static RubricaEntity daRubricaDTOARubricaEntity(RubricaDTO dto) {
		return new RubricaEntity(dto.getId(),dto.getNomePropietario(),dto.getAnnoDiCreazione());
	}
	
	
	public static RubricaDTO daRubricaEntityARubricaDTO(RubricaEntity entity) {
		return new RubricaDTO(entity.getId(),entity.getNomePropetario() , entity.getAnnoDiCreazione());
	}
	
	
	
	
	
	
	public ContattoEntity daContattoDTOAContattoEntity(ContattoDTO dto) {
		return new ContattoEntity(dto.getId(),dto.getNome(),dto.getCognome(),dto.getNumero(),dto.getGruppoDiAppartenenza(),dto.getDataDiNascita() , dto.isPreferred());
	}
	
	public ContattoDTO daContattoEntityAContattoDTO(ContattoEntity entity) {
		return new ContattoDTO(entity.getId(),entity.getNome(),entity.getCognome(),entity.getNumero(),entity.getGruppoDiAppartenenza(),entity.getDataDiNascita() , entity.isPreferred());
	}
	
	
}
