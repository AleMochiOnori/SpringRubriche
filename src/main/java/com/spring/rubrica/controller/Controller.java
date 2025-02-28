package com.spring.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.rubrica.DTO.RubricaDTO;
import com.spring.rubrica.service.RubricaService;

@RestController
@RequestMapping(path="/rubrica")
public class Controller {
	
	
	@Autowired
	private RubricaService service;
	
	
	
	
	@GetMapping(path="/registra" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean registra(@RequestBody RubricaDTO dto) {
		return service.inserisci(dto);
	}
	
	
	
	
	@GetMapping(path="/cercaPerId", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO cercaPerId(@RequestBody Integer id) {
		return service.cercaPerId(id);
	}
	
	
	
	 @GetMapping(path="/mostraTutti" , produces=MediaType.APPLICATION_JSON_VALUE)
		public List<RubricaDTO> mostraTutti(){
			return service.mostraContatti();
	}
	 
	
	
	
	
	 @GetMapping(path="/eliminaStudente/{matricola}" , produces=MediaType.APPLICATION_JSON_VALUE)
		public RubricaDTO eliminaUtente(@PathVariable int id) {
			return service.eliminaContatto(id);
	}
	 
	 
	 
	 
	 
	 
	
	
	
	
	
}
