package com.projetodrograria.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.projetodrograria.entities.Drograria;
import com.projetodrograria.services.DrograriaServices;


@RestController 

@RequestMapping("/drograria") 

public class DrograriaController { 

	private final DrograriaServices drograriaServices; 

	@Autowired 
	public DrograriaController(DrograriaServices drograriaService) { 
		this.drograriaServices = drograriaService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Drograria> buscaDrograriaControlId(@PathVariable Long id) { 
		Drograria drograria = drograriaServices.buscaDrograriaPeloCodigo(id); 
		if (drograria != null) { 
			return ResponseEntity.ok(drograria); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping 
	public ResponseEntity<List<Drograria>> buscaTodosDrograriaControl() { 
		List<Drograria> drograria = drograriaServices.buscaTodasDrograria(); 
		return ResponseEntity.ok(drograria); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Drograria> salvaDrograriaControl(@RequestBody Drograria drograria) { 
		Drograria salvaDrograria = drograriaServices.salvaDrograria(drograria); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaDrograria); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<Drograria> alteraDrograriaControl(@PathVariable Long id, @RequestBody Drograria drograria) { 
		Drograria alterarDrograria = drograriaServices.alterarDrograria(drograria, id); 
		if (alterarDrograria != null) { 
			return ResponseEntity.ok(drograria); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@DeleteMapping("/{codigo}") 
	public ResponseEntity<String> apagaDrograriaControl(@PathVariable Long id) { 
		boolean drograria = drograriaServices.apagarDrograria(id); 
		if (drograria) { 
			return ResponseEntity.ok().body("O Drograria foi excluído com sucesso"); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 


