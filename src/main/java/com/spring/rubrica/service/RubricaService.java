package com.spring.rubrica.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class RubricaService {
	@Autowired
	private RubricaDAO dao;
	
	
	public boolean inserisci(RubricaDTO dto) {
		
		RubricaEntity entity = Conversioni.daRubricaDTOARubricaEntity(dto);
		
		return dao.insert(entity);
	}
	
	
	
	public RubricaDTO cercaPerId(Integer id) {
		RubricaEntity rubrica=	dao.selectById(id);
		RubricaDTO dto = Conversioni.daRubricaEntityARubricaDTO(rubrica);
		return dto;	
		
		
				
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
	    	throw new RuntimeException("La rubrica è vuota");
	    }
	    RubricaEntity rubricaPiuVecchia = list.stream()
	            .min(Comparator.comparingInt(RubricaEntity::getAnnoDiCreazione))
	            .orElse(null);

	    if (rubricaPiuVecchia != null) {
	        return new nomeListaPiùVecchia(rubricaPiuVecchia.getNomePropetario(), rubricaPiuVecchia.getAnnoDiCreazione());
	    } else {
	    	throw new RuntimeException("La rubrica non esiste");
	    }
	}

	
	
	public List<AnnoCreazioneDTO> visulizzaAnniCreazioneOrdineCrescente(){
		List<RubricaEntity> list = dao.selectAll();
	    if (list.isEmpty()) {
	    	throw new RuntimeException("La rubrica è vuota");
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

	    throw new RuntimeException("Il contatto non esiste");
	}

	public List<ContattoDTO> mostraTuttiIContatti(Integer idRubrica) {
		 RubricaEntity contatto = dao.selectById(idRubrica);
		 ArrayList<ContattoDTO> listaDto = new ArrayList<>();
		 for(ContattoEntity c : contatto.getListaContatti()) {
			listaDto.add(Conversioni.daContattoEntityAContattoDTO(c));
		}
		return listaDto;
	}
	
	
	
	public Integer contattiRegistrati(Integer idRubrica) {
		RubricaEntity rubrica = dao.selectById(idRubrica);
		if (rubrica == null) {
			throw new RuntimeException("La rubrica non esiste");
		}
		List<ContattoEntity> listaContatti = rubrica.getListaContatti();
		if (listaContatti == null) {
			throw new RuntimeException("La rubrica è vuota");
		}
		return listaContatti.size();
	}
	
	
	
	public ContattoDTO ricercaByNumero(Integer idRubrica , Integer numero) {
		RubricaEntity rubrica = dao.selectById(idRubrica);
		for(ContattoEntity c : rubrica.getListaContatti()) {
			if (c.getNumero() == numero) {
				return Conversioni.daContattoEntityAContattoDTO(c);
			}
				
				throw new RuntimeException("Il numero di appartenenza non esiste");
			}
				
		throw new RuntimeException("Il contatto non esiste");
	}
	
	
	
	public NomeCognomeGruppoDTO ricercaByGruppo(Integer idRubrica , String nomeGruppo) {
		RubricaEntity rubrica = dao.selectById(idRubrica);
		for(ContattoEntity contatto : rubrica.getListaContatti()) {
			if (contatto.getGruppoDiAppartenenza().equals(nomeGruppo) ) {
				return new NomeCognomeGruppoDTO(contatto.getNome() , contatto.getCognome());
				}
			
			throw new RuntimeException("Il nome del gruppo non esiste");
			
				
			}
		
		throw new RuntimeException("Il contatto non esiste");
		
	}
	
	public List<ContattoDTO> eliminaContattiDaGruppo(Integer idRubrica , String nomeGruppo){
		RubricaEntity rubrica = dao.selectById(idRubrica);
		for(ContattoEntity contatto : rubrica.getListaContatti()) {
			if (contatto.getGruppoDiAppartenenza().equals(nomeGruppo) ) {
				dao.delete(contatto.getId());
			}
			
			throw new RuntimeException("Il nome del gruppo non esiste");
		}
		
		throw new RuntimeException("Il contatto non esiste");
	}
	
	
	public ContattoDTO modificaPreferenza(Integer idRubrica) {
		RubricaEntity rubrica = dao.selectById(idRubrica);
		for(ContattoEntity contatto : rubrica.getListaContatti()) {
			contatto.setPreferred(true) ;
		}
		
		throw new RuntimeException("Il contatto non esiste");
	}
	
	
	
	public ContattoDTO ricercaPreferiti(Integer idRubrica) {
		RubricaEntity rubrica = dao.selectById(idRubrica);
		ArrayList<ContattoDTO> preferiti = new ArrayList<>();
		for(ContattoEntity contatto : rubrica.getListaContatti()) {
			if (contatto.getIsPreferred() == true) {
				preferiti.add(Conversioni.daContattoEntityAContattoDTO(contatto));
			}
		}
		
		throw new RuntimeException("Il contatto non esiste");
	}
}

	
		

	

