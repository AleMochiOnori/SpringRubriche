package com.spring.rubrica.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.rubrica.DAO.RubricaDAO;
import com.spring.rubrica.DTO.NomiPropietariDTO;
import com.spring.rubrica.DTO.PropietarioAnnoCreazioneDTO;
import com.spring.rubrica.DTO.PropietarioNumContatti;
import com.spring.rubrica.DTO.RubricaDTO;
import com.spring.rubrica.DTO.nomeListaPiùVecchia;
import com.spring.rubrica.DTO.AnnoCreazioneDTO;
import com.spring.rubrica.DTO.ContattoDTO;
import com.spring.rubrica.DTO.NomeCognomeGruppoDTO;
import com.spring.rubrica.entity.ContattoEntity;
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
	
	public RubricaDTO modificaAnno(int id , int anno) {
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
	
	
	
	
	public nomeListaPiùVecchia visualizzaPropietarioEListaVecchia() {
	    List<RubricaEntity> list = dao.selectAll();
	    if (list.isEmpty()) {
	        return null;
	    }
	    RubricaEntity rubricaPiuVecchia = list.stream()
	            .min(Comparator.comparingInt(RubricaEntity::getAnnoDiCreazione))
	            .orElse(null);

	    if (rubricaPiuVecchia != null) {
	        return new nomeListaPiùVecchia(rubricaPiuVecchia.getNomePropetario(), rubricaPiuVecchia.getAnnoDiCreazione());
	    } else {
	        return null;
	    }
	}

	
	
	public List<AnnoCreazioneDTO> visulizzaAnniCreazioneOrdineCrescente(){
		List<RubricaEntity> list = dao.selectAll();
	    if (list.isEmpty()) {
	        return null;
	    }
	    List<AnnoCreazioneDTO> ordered = list.stream()
	               .sorted(Comparator.comparingInt(RubricaEntity::getAnnoDiCreazione)) 
	               .map(r -> new AnnoCreazioneDTO(r.getAnnoDiCreazione())) 
	               .collect(Collectors.toList());	
	    
	    
	    return ordered;
	}
	
	
	
	
	public PropietarioNumContatti visualizzaPrimoPropietarioENumeroContatti() {
	    return dao.selectAll().stream()
	        .map(r -> new PropietarioNumContatti(r.getNomePropetario(), r.getListaContatti().size()))  
	        .findFirst()
	        .orElse(null); 
	}

	
	
	
	
	public boolean inserisciContatto(Integer idRubrica, ContattoDTO dto) {
	    ContattoEntity entity = Conversioni.daContattoDTOAContattoEntity(dto);
	    return dao.addContattoToRubrica(idRubrica, entity);
	}

	public ContattoDTO cercaContattoPerId(Integer idRubrica , Integer idContatto) {
		ContattoEntity rubrica = dao.selectContattoById(idRubrica , idContatto);
		ContattoDTO rubDto = Conversioni.daContattoEntityAContattoDTO(rubrica);
		 return rubDto ;
	}
	
	
	public ContattoEntity modificaContatto(Integer idRubrica, ContattoDTO dto) {
	    ContattoEntity contatto = dao.selectContattoById(idRubrica, dto.getId());
	    if (contatto != null) { 
	        contatto.setNome(dto.getNome());
	        contatto.setCognome(dto.getCognome());
	        contatto.setNumero(dto.getNumero());
	        contatto.setGruppoDiAppartenenza(dto.getGruppoDiAppartenenza());
	        contatto.setDataDiNascita(dto.getDataDiNascita());
	        contatto.setPreferred(dto.getIsPreferred());

	        return contatto; 
	    }

	    return null;
	}

	public List<ContattoDTO> mostraTuttiIContatti() {
		List<RubricaEntity> list =  dao.selectAll();
		ArrayList<ContattoDTO> listaDto = new ArrayList<>();
		
		for (RubricaEntity rubrica : list) {
			for(ContattoEntity contatto : rubrica.getListaContatti()) {
				listaDto.add(Conversioni.daContattoEntityAContattoDTO(contatto));
			}
			
		}
		
		return listaDto;
	}
	
	
	
	public Integer contattiRegistrati() {
		List<RubricaEntity> list =  dao.selectAll();
		Integer numeroContatti = 0 ;
		for (RubricaEntity rubrica : list) {
			List<ContattoEntity> listaContatti = rubrica.getListaContatti();
			 numeroContatti += listaContatti.size();
			
		}
		
		return numeroContatti;
	}
	
	
	
	public ContattoDTO ricercaByNumero(Integer numero) {
		List<RubricaEntity> list =  dao.selectAll();
		for (RubricaEntity rubrica : list) {
			for(ContattoEntity contatto : rubrica.getListaContatti()) {
				if (contatto.getNumero() == numero) {
					 return Conversioni.daContattoEntityAContattoDTO(contatto);
				}
			
				
			}
				
		}
		return null;
	}
	
	
	
	public NomeCognomeGruppoDTO ricercaByGruppo(String nomeGruppo) {
		List<RubricaEntity> list =  dao.selectAll();
		for (RubricaEntity rubrica : list) {
			for(ContattoEntity contatto : rubrica.getListaContatti()) {
				if (contatto.getGruppoDiAppartenenza().equals(nomeGruppo) ) {
					return new NomeCognomeGruppoDTO(contatto.getNome() , contatto.getCognome());
				}
			
				
			}
				
		}
		return null;
		
	}
	
	public List<ContattoDTO> eliminaContattiDaGruppo(String nomeGruppo){
		List<RubricaEntity> list =  dao.selectAll();
		for (RubricaEntity rubrica : list) {
			for(ContattoEntity contatto : rubrica.getListaContatti()) {
				if (contatto.getGruppoDiAppartenenza().equals(nomeGruppo) ) {
					dao.delete(contatto.getId());
				}
			
				
			}
		}
		
		return null;
	}
	
	
	public ContattoDTO modificaPreferenza() {
		List<RubricaEntity> list =  dao.selectAll();
		for (RubricaEntity rubrica : list) {
			for(ContattoEntity contatto : rubrica.getListaContatti()) {
				contatto.setPreferred(true) ;
			}
		}
		
		return null;
	}
	
	
	
	public ContattoDTO ricercaPreferiti() {
		List<RubricaEntity> list =  dao.selectAll();
		ArrayList<ContattoDTO> preferiti = new ArrayList<>();
		for (RubricaEntity rubrica : list) {
			for(ContattoEntity contatto : rubrica.getListaContatti()) {
				if (contatto.getIsPreferred() == true) {
					preferiti.add(Conversioni.daContattoEntityAContattoDTO(contatto));
				}
			}
	
		}
		
		return null;
	}
}

	
		

	

