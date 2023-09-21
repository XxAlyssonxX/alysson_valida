package com.projetodrograria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodrograria.entities.Medicamento;
import com.projetodrograria.repository.MedicamentoRepository;

@Service 
public class MedicamentoService { 

	private final MedicamentoRepository medicamentoRepository; 

	@Autowired 
	public MedicamentoService(MedicamentoRepository medicamentoRepository) { 
		this.medicamentoRepository = medicamentoRepository; 
	} 

	public List<Medicamento> buscaTodosMedicamento() { 
		return medicamentoRepository.findAll(); 
	} 

	public Medicamento buscaMedicamentoPeloCodigo(Long id) { 
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id); 
		return medicamento.orElse(null); 
	} 

	public Medicamento salvaMedicamento(Medicamento medicamento) { 
		return medicamentoRepository.save(medicamento); 
	} 

	public Medicamento alterarMedicamento(Medicamento alterarMedicamento, Long id) { 
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id); 
		if (existeMedicamento.isPresent()) { 
			alterarMedicamento.setId(id); 
			return medicamentoRepository.save(alterarMedicamento); 
		} 
		return null; 
	} 


	public boolean apagarMedicamento(Long id) { 
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id); 
		if (existeMedicamento.isPresent()) { 
			medicamentoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
}
