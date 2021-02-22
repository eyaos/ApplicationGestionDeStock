package com.gestion.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestiondestock.api.UtilisateurApi;
import com.gestion.gestiondestock.dto.UtilisateurDto;
import com.gestion.gestiondestock.services.UtilisateurService;

@RestController
public class UtilisateurController implements UtilisateurApi{
	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		return utilisateurService.save(dto);
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		return utilisateurService.findById(id);
	}

	@Override
	public UtilisateurDto findByNomUtilisateur(String nomUtilisateur) {
		return utilisateurService.findByNomUtilisateur(nomUtilisateur);
	}

	@Override
	public List<UtilisateurDto> findAll() {
		return utilisateurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		utilisateurService.delete(id);
	}
}
