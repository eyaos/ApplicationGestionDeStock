package com.gestion.gestiondestock.services;

import java.util.List;

import com.gestion.gestiondestock.dto.UtilisateurDto;

public interface UtilisateurService {
	UtilisateurDto save(UtilisateurDto dto);
	UtilisateurDto findById(Integer id);
	UtilisateurDto findByNomUtilisateur(String nomUtilisateur);
	List<UtilisateurDto> findAll();
	void delete (Integer id);

}
