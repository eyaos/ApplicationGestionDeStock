package com.gestion.gestiondestock.services;

import java.util.List;

import com.gestion.gestiondestock.dto.EntrepriseDto;

public interface EntrepriseService {
	EntrepriseDto save(EntrepriseDto dto);
	EntrepriseDto findById(Integer id);
	EntrepriseDto findByNomEntreprise(String nomEntreprise);
	List<EntrepriseDto> findAll();
	void delete (Integer id);

}
