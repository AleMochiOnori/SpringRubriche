package com.spring.rubrica.conversioni;

import java.util.ArrayList;
import java.util.List;

import com.spring.rubrica.DTO.ContattoDTO;
import com.spring.rubrica.DTO.RubricaDTO;
import com.spring.rubrica.entity.ContattoEntity;
import com.spring.rubrica.entity.RubricaEntity;

public class Conversioni {
	
	
	
	
		
	public static RubricaEntity daRubricaDTOARubricaEntity(RubricaDTO dto) {
        List<ContattoEntity> contatti = new ArrayList<>();
        for(ContattoDTO contattoDTO:dto.getListaContatti()) {
            contatti.add(daContattoDTOAContattoEntity(contattoDTO));
        }
            return new RubricaEntity(dto.getId(), dto.getNomePropietario(), dto.getAnnoDiCreazione(), contatti);
    }

    public static RubricaDTO daRubricaEntityARubricaDTO(RubricaEntity entity) {
        List<ContattoDTO> contattiDTO = new ArrayList<>();
        for(ContattoEntity contatto:entity.getListaContatti()) {
            contattiDTO.add(daContattoEntityAContattoDTO(contatto));
        }
        return new RubricaDTO(entity.getId(), entity.getNomePropetario(), entity.getAnnoDiCreazione(), contattiDTO);
    }
	
	
	
	
	

	public static ContattoEntity daContattoDTOAContattoEntity(ContattoDTO dto) {
		return new ContattoEntity(dto.getId(),dto.getNome(),dto.getCognome(),dto.getNumero(),dto.getGruppoDiAppartenenza(),dto.getDataDiNascita() , dto.getIsPreferred());
	}
	
	public static ContattoDTO daContattoEntityAContattoDTO(ContattoEntity entity) {
		return new ContattoDTO(entity.getId(),entity.getNome(),entity.getCognome(),entity.getNumero(),entity.getGruppoDiAppartenenza(),entity.getDataDiNascita() , entity.getIsPreferred());
	}
	
	
}
