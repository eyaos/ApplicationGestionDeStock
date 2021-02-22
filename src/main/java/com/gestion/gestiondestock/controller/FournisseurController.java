package com.gestion.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestiondestock.api.FournisseurApi;
import com.gestion.gestiondestock.dto.FournisseurDto;
import com.gestion.gestiondestock.services.FournisseurService;

@RestController
public class FournisseurController implements FournisseurApi{
	@Autowired
	private FournisseurService fournisseurService;

	@Autowired
	public FournisseurController(FournisseurService FournisseurService) {
		this.fournisseurService = FournisseurService;
	}

	@Override
	public FournisseurDto save(FournisseurDto dto) {
		return fournisseurService.save(dto);
	}

	@Override
	public FournisseurDto findById(Integer id) {
		return fournisseurService.findById(id);
	}

	@Override
	public FournisseurDto findByNomFournisseur(String nomFournisseur) {
		return fournisseurService.findByNomFournisseur(nomFournisseur);
	}

	@Override
	public List<FournisseurDto> findAll() {
		return fournisseurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		fournisseurService.delete(id);
	}
}
