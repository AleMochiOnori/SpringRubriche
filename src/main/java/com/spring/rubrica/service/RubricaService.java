package com.spring.rubrica.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.rubrica.DAO.RubricaDAO;
import com.spring.rubrica.DTO.NomiPropietariDTO;
import com.spring.rubrica.DTO.PropietarioAnnoCreazioneDTO;
import com.spring.rubrica.DTO.RubricaDTO;
import com.spring.rubrica.DTO.nomeListaPiùVecchia;
import com.spring.rubrica.entity.RubricaEntity;
import com.spring.rubrica.conversioni.Conversioni;

public class RubricaService {
	@Autowired
	private RubricaDAO dao;
	
	
	public boolean inserisci(RubricaDTO dto) {
		
		RubricaEntity entity = Conversioni.daRubricaDTOARubricaEntity(dto);
		
		return dao.insert(entity);
	}
	
	
	
	public RubricaDTO cercaPerId(Integer id) {
		RubricaEntity rubrica=	dao.selectById(id);
		if(rubrica != null) {
			RubricaDTO dto = Conversioni.daRubricaEntityARubricaDTO(rubrica);
			return dto;	
		}
		
		return null;
		
			
	}
	
	
	
	public List<RubricaDTO> mostraContatti() {
		List<RubricaEntity> list =  dao.selectAll();
		ArrayList<RubricaDTO> listaDto = new ArrayList<>();
		
		for (RubricaEntity contact : list) {
			RubricaDTO dto1 = Conversioni.daRubricaEntityARubricaDTO(contact);
			listaDto.add(dto1);
		}
		
		return listaDto;
	}
	
	
	public RubricaDTO  eliminaContatto(int id) {
		RubricaEntity contatto = dao.selectById(id);
			if (contatto != null) {
				RubricaDTO dto2 = Conversioni.daRubricaEntityARubricaDTO(contatto);
				dao.delete(id);
				return dto2;
			}
			
			return null;
			
			
		}
	
	
	
	public PropietarioAnnoCreazioneDTO nomeAnnoCreazione(int id) {
		RubricaEntity contatto = dao.selectById(id);
		if (contatto != null) {
			RubricaDTO dto2 = Conversioni.daRubricaEntityARubricaDTO(contatto);
			return new PropietarioAnnoCreazioneDTO(dto2.getNomePropietario(),dto2.getAnnoDiCreazione()); 
		}
		return null;
	}
	
	
	
	public RubricaDTO modificaNome(int id , String nome) {
		RubricaEntity rubrica = dao.selectById(id);
		if (rubrica != null) {
			RubricaDTO dto2 = Conversioni.daRubricaEntityARubricaDTO(rubrica);
			dto2.setNomePropietario(nome);
			return dto2;
		}
		return null;
	}
	
	public RubricaDTO modificaAnno(int id , String anno) {
		RubricaEntity rubrica = dao.selectById(id);
		if (rubrica != null) {
			RubricaDTO dto2 = Conversioni.daRubricaEntityARubricaDTO(rubrica);
			dto2.setAnnoDiCreazione(anno);
			return dto2;
		}
		return null;
	}
	
	public NomiPropietariDTO visualizzaPropietari() {
		  List<RubricaEntity>utenti = dao.selectAll();
	      NomiPropietariDTO utentidto = new NomiPropietariDTO ();
	      ArrayList<String> nome = new ArrayList<>();
	      for(RubricaEntity utente:utenti) {
	          nome.add(utente.getNomePropetario());
	          utentidto.setProp(nome);
	          utentidto.getContatore();
	       }
	        
	        
	        return utentidto;


	    }
	
	
	
	
	public nomeListaPiùVecchia visualizzaPropietarioEListaVecchia(){
		ArrayList<RubricaEntity> list =  dao.selectAll();
	    ArrayList<nomeListaPiùVecchia> listaNomiAnni = new ArrayList<>();
	    for(RubricaEntity utente : list) {
	       nomeListaPiùVecchia rubrica = new nomeListaPiùVecchia(utente.getNomePropetario() , utente.getAnnoDiCreazione());
	       listaNomiAnni.add(rubrica);
	       listaNomiAnni.sort(Comparator.comparing(nomeListaPiùVecchia::getAnnoDiCreazione));
	    }
		
		return list;
		
	}
	
	
	
	
	
	}
		

	

