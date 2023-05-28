package com.prova.java.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;


import com.prova.java.model.Compromisso;
import com.prova.java.repository.CompromisssoRepository;

@RestController
public class CompromissoController {
   @Autowired
	private CompromisssoRepository cr;
	
    /*@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String nome) {
    	Compromisso compromisso = new Compromisso();
    	compromisso.setNome(nome);
    	cr.save(compromisso);
        return "Hello " + nome + "!";
    }*/
    @GetMapping(value = "listatodos")
    @ResponseBody
    public ResponseEntity<List<Compromisso>>listaCompromisso(){
    	List<Compromisso> compromissos =  cr.findAll();
    	return new ResponseEntity<List<Compromisso>>(compromissos, HttpStatus.OK);
    	
    }
    @PostMapping(value = "salvar")
    @ResponseBody
    public ResponseEntity<Compromisso> salvar(@RequestBody Compromisso compromisso){
    	Compromisso c = cr.save(compromisso);
    	return new ResponseEntity<Compromisso>(c, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<Compromisso> atualizar(@RequestBody Compromisso compromisso){
    	Compromisso c = cr.saveAndFlush(compromisso);
    	return new ResponseEntity<Compromisso>(c, HttpStatus.OK);
    }
    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idcompromisso){
    	cr.deleteById(idcompromisso);
    	return new ResponseEntity<String>("Compromisso Deletado Com Sucesso", HttpStatus.CREATED);
    }
   
    @GetMapping(value = "buscarCompromissoid")
    @ResponseBody
    public ResponseEntity<Compromisso> buscarCompromissoid (@RequestParam (name = "idcompromisso") Long idcompromisso){
    	Compromisso compromisso = cr.findById(idcompromisso).get();
    	return new ResponseEntity<Compromisso>(compromisso, HttpStatus.CREATED);
    }
    @GetMapping(value = "buscarPorNome")
    @ResponseBody
    public ResponseEntity<List<Compromisso>> buscarPorNome (@RequestBody @RequestParam (name = "nome") String nome){
    	List<Compromisso>compromisso = cr.buscarPorNome(nome);
    	return new ResponseEntity<List<Compromisso>>(compromisso, HttpStatus.CREATED);
    }
	
  
}
