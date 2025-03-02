package com.spring.rubrica.controller;

import com.spring.rubrica.DTO.*;
import com.spring.rubrica.entity.ContattoEntity;
import com.spring.rubrica.service.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rubrica")
public class Controller {

    @Autowired
    private RubricaService rubricaService;

  
    @PostMapping("/inserisci")
    public boolean inserisciRubrica(@RequestBody RubricaDTO dto) {
        return rubricaService.inserisci(dto);
    }

   
    @GetMapping("/cerca/{id}")
    public RubricaDTO cercaPerId(@PathVariable Integer id) {
        return rubricaService.cercaPerId(id);
    }

  
    @GetMapping("/tutte")
    public List<RubricaDTO> mostraRubriche() {
        return rubricaService.mostraContatti();
    }

   
    @DeleteMapping("/elimina/{id}")
    public RubricaDTO eliminaRubrica(@PathVariable int id) {
        return rubricaService.eliminaContatto(id);
    }

  
    @PutMapping("/modifica/nome/{id}")
    public RubricaDTO modificaNome(@PathVariable int id, @RequestParam String nome) {
        return rubricaService.modificaNome(id, nome);
    }

 
    @PutMapping("/modifica/anno/{id}")
    public RubricaDTO modificaAnno(@PathVariable int id, @RequestParam int anno) {
        return rubricaService.modificaAnno(id, anno);
    }


    @GetMapping("/proprietario-vecchio")
    public nomeListaPiùVecchia proprietarioVecchio() {
        return rubricaService.visualizzaPropietarioEListaVecchia();
    }

  
    @GetMapping("/anni-creazione")
    public List<AnnoCreazioneDTO> anniCreazione() {
        return rubricaService.visulizzaAnniCreazioneOrdineCrescente();
    }


    @PostMapping("/contatto/inserisci/{idRubrica}")
    public boolean inserisciContatto(@PathVariable Integer idRubrica, @RequestBody ContattoDTO dto) {
        return rubricaService.inserisciContatto(idRubrica, dto);
    }

    
    @GetMapping("/contatto/cerca/{idRubrica}/{idContatto}")
    public ContattoDTO cercaContatto(@PathVariable Integer idRubrica, @PathVariable Integer idContatto) {
        return rubricaService.cercaContattoPerId(idRubrica, idContatto);
    }

 
    @PutMapping("/contatto/modifica/{idRubrica}")
    public ContattoEntity modificaContatto(@PathVariable Integer idRubrica, @RequestBody ContattoDTO dto) {
        return rubricaService.modificaContatto(idRubrica, dto);
    }

  
    @GetMapping("/contatti/tutti")
    public List<ContattoDTO> mostraTuttiIContatti() {
        return rubricaService.mostraTuttiIContatti();
    }

    @GetMapping("/contatti/conta")
    public Integer contattiRegistrati() {
        return rubricaService.contattiRegistrati();
    }


    @GetMapping("/contatti/cerca-numero/{numero}")
    public ContattoDTO ricercaByNumero(@PathVariable Integer numero) {
        return rubricaService.ricercaByNumero(numero);
    }

   
    @GetMapping("/contatti/cerca-gruppo/{nomeGruppo}")
    public NomeCognomeGruppoDTO ricercaByGruppo(@PathVariable String nomeGruppo) {
        return rubricaService.ricercaByGruppo(nomeGruppo);
    }

  
    @DeleteMapping("/contatti/elimina-gruppo/{nomeGruppo}")
    public List<ContattoDTO> eliminaContattiDaGruppo(@PathVariable String nomeGruppo) {
        return rubricaService.eliminaContattiDaGruppo(nomeGruppo);
    }

  
    @PutMapping("/contatti/modifica-preferito")
    public ContattoDTO modificaPreferenza() {
        return rubricaService.modificaPreferenza();
    }

  
    @GetMapping("/contatti/preferiti")
    public ContattoDTO ricercaPreferiti() {
        return rubricaService.ricercaPreferiti();
    }
}
