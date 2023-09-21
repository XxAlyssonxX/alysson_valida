package com.projetodrograria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodrograria.entities.Drograria;
import com.projetodrograria.repository.DrograriaRepository;

@Service 
public class DrograriaServices { 

	private final DrograriaRepository drograriaRepository; 

	@Autowired 
	public DrograriaServices(DrograriaRepository drograriaRepository) { 
		this.drograriaRepository = drograriaRepository; 
	} 

	public List<Drograria> buscaTodasDrograria() { 
		return drograriaRepository.findAll(); 
	} 

	public Drograria buscaDrograriaPeloCodigo(Long id) { 
		Optional<Drograria> drograria = drograriaRepository.findById(id); 
		return drograria.orElse(null); 
	} 

	public Drograria salvaDrograria(Drograria drograria) { 
		return drograriaRepository.save(drograria); 
	} 

	public Drograria alterarDrograria(Drograria alterarDrograria, Long id) { 
		Optional<Drograria> existeDrograria = drograriaRepository.findById(id); 
		if (existeDrograria.isPresent()) { 
			alterarDrograria.setId(id); 
			return drograriaRepository.save(alterarDrograria); 
		} 
		return null; 
	} 


	public boolean apagarDrograria(Long id) { 
		Optional<Drograria> existeDrograria = drograriaRepository.findById(id); 
		if (existeDrograria.isPresent()) { 
			drograriaRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
}