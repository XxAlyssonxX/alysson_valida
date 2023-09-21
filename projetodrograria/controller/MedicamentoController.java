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

import com.projetodrograria.entities.Medicamento;
import com.projetodrograria.services.MedicamentoService;



@RestController 
@RequestMapping("/medicamento") 
public class MedicamentoController { 

	private final MedicamentoService medicamentoService; 

	@Autowired 
	public MedicamentoController(MedicamentoService medicamentoService) { 
		this.medicamentoService = medicamentoService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Medicamento> buscaMedicamentoControlId(@PathVariable Long id) { 
		Medicamento medicamento = medicamentoService.buscaMedicamentoPeloCodigo(id); 
		if (medicamento != null) { 
			return ResponseEntity.ok(medicamento); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping 
	public ResponseEntity<List<Medicamento>> buscaTodosmedicamentoControl() { 
		List<Medicamento> medicamento = medicamentoService.buscaTodosMedicamento(); 
		return ResponseEntity.ok(medicamento); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Medicamento> salvaMedicamentoControl(@RequestBody Medicamento medicamento) { 
		Medicamento salvaMedicamento = medicamentoService.salvaMedicamento(medicamento); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaMedicamento); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<Medicamento> alteramedicamentoControl(@PathVariable Long id, @RequestBody Medicamento medicamento) { 
		Medicamento alterarmedicamento = medicamentoService.alterarMedicamento(medicamento, id); 
		if (alterarmedicamento != null) { 
			return ResponseEntity.ok(medicamento); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@DeleteMapping("/{codigo}") 
	public ResponseEntity<String> apagaMedicamentoControl(@PathVariable Long id) { 
		boolean medicamento = medicamentoService.apagarMedicamento(id); 
		if (medicamento) { 
			return ResponseEntity.ok().body("O medicamento foi excluído com sucesso"); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 