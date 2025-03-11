package com.spring.rubrica.controller;

import com.spring.rubrica.DTO.*;
import com.spring.rubrica.entity.ContattoEntity;
import com.spring.rubrica.service.RubricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rubrica")
public class Controller {

    @Autowired
    private RubricaService rubricaService;

    @PostMapping("")
    public boolean inserisci(@RequestBody RubricaDTO dto) {
        return rubricaService.inserisci(dto);
    }

    @GetMapping("/cerca/{id}")
    public RubricaDTO cercaPerId(@PathVariable Integer id) {
        return rubricaService.cercaPerId(id);
    }

    @GetMapping("/mostra")
    public List<RubricaDTO> mostraContatti() {
        return rubricaService.mostraContatti();
    }

    @DeleteMapping("/elimina/{id}")
    public RubricaDTO eliminaContatto(@PathVariable int id) {
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

    @GetMapping("/propietari")
    public NomiPropietariDTO visualizzaPropietari() {
        return rubricaService.visualizzaPropietari();
    }

    @GetMapping("/propietario-vecchio")
    public nomeListaPiùVecchia visualizzaPropietarioEListaVecchia() {
        return rubricaService.visualizzaPropietarioEListaVecchia();
    }

    @GetMapping("/anni-creazione")
    public List<AnnoCreazioneDTO> visulizzaAnniCreazioneOrdineCrescente() {
        return rubricaService.visulizzaAnniCreazioneOrdineCrescente();
    }

    @PostMapping("/contatto/inserisci/{idRubrica}")
    public boolean inserisciContatto(@PathVariable Integer idRubrica, @RequestBody ContattoDTO dto) {
        return rubricaService.inserisciContatto(idRubrica, dto);
    }

    @GetMapping("/contatto/cerca/{idRubrica}/{idContatto}")
    public ContattoDTO cercaContattoPerId(@PathVariable Integer idRubrica, @PathVariable Integer idContatto) {
        return rubricaService.cercaContattoPerId(idRubrica, idContatto);
    }

    @PutMapping("/contatto/modifica/{idRubrica}")
    public ContattoEntity modificaContatto(@PathVariable Integer idRubrica, @RequestBody ContattoDTO dto) {
        return rubricaService.modificaContatto(idRubrica, dto);
    }

    @GetMapping("/contatti/{idRubrica}")
    public List<ContattoDTO> mostraTuttiIContatti(@PathVariable Integer idRubrica) {
        return rubricaService.mostraTuttiIContatti(idRubrica);
    }

    @GetMapping("/contatti/numero/{idRubrica}")
    public Integer contattiRegistrati(@PathVariable Integer idRubrica) {
        return rubricaService.contattiRegistrati(idRubrica);
    }

    @GetMapping("/contatto/numero/{idRubrica}/{numero}")
    public ContattoDTO ricercaByNumero(@PathVariable Integer idRubrica, @PathVariable Integer numero) {
        return rubricaService.ricercaByNumero(idRubrica, numero);
    }

    @GetMapping("/contatto/gruppo/{idRubrica}/{nomeGruppo}")
    public NomeCognomeGruppoDTO ricercaByGruppo(@PathVariable Integer idRubrica, @PathVariable String nomeGruppo) {
        return rubricaService.ricercaByGruppo(idRubrica, nomeGruppo);
    }

    @DeleteMapping("/contatti/gruppo/{idRubrica}/{nomeGruppo}")
    public List<ContattoDTO> eliminaContattiDaGruppo(@PathVariable Integer idRubrica, @PathVariable String nomeGruppo) {
        return rubricaService.eliminaContattiDaGruppo(idRubrica, nomeGruppo);
    }

    @PutMapping("/contatto/preferito/{idRubrica}")
    public ContattoDTO modificaPreferenza(@PathVariable Integer idRubrica) {
        return rubricaService.modificaPreferenza(idRubrica);
    }

    @GetMapping("/contatto/preferiti/{idRubrica}")
    public ContattoDTO ricercaPreferiti(@PathVariable Integer idRubrica) {
        return rubricaService.ricercaPreferiti(idRubrica);
    }
    
    
    @ExceptionHandler
    public ResponseEntity<ErroreDTO> handler(RuntimeException exc){
    	ErroreDTO error = new ErroreDTO(exc.getMessage());
    	ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    	return response;
    }
    
}
