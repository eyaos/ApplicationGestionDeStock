package com.gestion.gestiondestock.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.gestiondestock.dto.FournisseurDto;

public interface FournisseurApi {
	@PostMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	FournisseurDto save( @RequestBody FournisseurDto dto);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Fournisseur/id/{idFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE )
	FournisseurDto findById(@PathVariable("idFournisseur") Integer id);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Fournisseur/nom/{nomFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE )
	FournisseurDto findByNomFournisseur(@PathVariable("nomFournisseur") String nomFournisseur);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Fournisseur/all",produces = MediaType.APPLICATION_JSON_VALUE )
    List<FournisseurDto> findAll();
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Fournisseur/delete/id/{idFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE )
    void delete (@PathVariable("idFournisseur") Integer id);
}
