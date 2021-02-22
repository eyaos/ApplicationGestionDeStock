package com.gestion.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestiondestock.api.EntrepriseApi;
import com.gestion.gestiondestock.dto.EntrepriseDto;
import com.gestion.gestiondestock.services.EntrepriseService;

@RestController
public class EntrepriseController implements EntrepriseApi {
	@Autowired
	private EntrepriseService entrepriseService;

	@Autowired
	public EntrepriseController(EntrepriseService EntrepriseService) {
		this.entrepriseService = EntrepriseService;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
		return entrepriseService.save(dto);
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		return entrepriseService.findById(id);
	}

	@Override
	public EntrepriseDto findByNomEntreprise(String nomEntreprise) {
		return entrepriseService.findByNomEntreprise(nomEntreprise);
	}

	@Override
	public List<EntrepriseDto> findAll() {
		return entrepriseService.findAll();
	}

	@Override
	public void delete(Integer id) {
		entrepriseService.delete(id);
	}
}
