package com.intelifis.api.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.intelifis.api.controller.files.FileInfo;
import com.intelifis.api.controller.files.FilesStorageService;
import com.intelifis.api.model.*;
import com.intelifis.api.repository.*;


@RestController
@RequestMapping("/arquivo")
public class ArquivoController {
	  
	@Autowired
	private PlanoRepository planoRepository;
	
	@Autowired
	private BalancoRepository balancoRepository;
	

	@CrossOrigin
	@PostMapping("/plano")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> addPlano(@RequestBody Arquivo arq) {
		arq.lerObj(arq.getCaminho(), "plano");
		List<Plano> lista = arq.getPln();
		this.planoRepository.saveAll(lista);
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "resultado", "importou")); 
	}

	
	
	@CrossOrigin
	@PostMapping("/balanco")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> addBalanco(@RequestBody Arquivo arq) {
		arq.lerObj(arq.getCaminho(), "balanco");
		List<Balanco> lista = arq.getBal();
		this.balancoRepository.saveAll(lista);
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "resultado", "importou")); 
	}
	
	



	



}
	
	
	
	
	
	/*
	 * 
	 * @PostMapping("/balanco")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Balanco> addBalanco(@RequestBody Arquivo arq) {
		arq.lerObj(arq.getCaminho(), "balanco");
		List<Balanco> lista = arq.getBal();
		return balancoRepository.saveAll(lista);
	}
	@RequestMapping(value = "/{authorizationUrl}", method = { RequestMethod.DELETE} )
	@ResponseBody
	public void deleteAuthorizationServer(
	    @RequestHeader(value="Authorization") String authorization,
	    @PathVariable("authorizationUrl") String authorizationUrl
	){
		planoRepository.deleteAll();
	    System.out.printf("Testing: You tried to delete %s using %s\n", authorizationUrl, authorization);
	}
	
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return planoRepository.findById(id)
	           .map(record -> {
	               planoRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path = "all")
	  public ResponseEntity<HttpStatus> deleteAll() {
	    try {
	    	planoRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	  }
*/

	




