package com.gestion.gestiondestock.services;

import java.util.List;

import com.gestion.gestiondestock.dto.FournisseurDto;

public interface FournisseurService {
	FournisseurDto save(FournisseurDto dto);
	FournisseurDto findById(Integer id);
	FournisseurDto findByNomFournisseur(String nomFournisseur);
	List<FournisseurDto> findAll();
	void delete (Integer id);

}
