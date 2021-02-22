package com.gestion.gestiondestock.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.gestiondestock.dto.UtilisateurDto;

public interface UtilisateurApi {
	@PostMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	UtilisateurDto save( @RequestBody UtilisateurDto dto);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Utilisateur/id/{idUtilisateur}",produces = MediaType.APPLICATION_JSON_VALUE )
	UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Utilisateur/nom/{nomUtilisateur}",produces = MediaType.APPLICATION_JSON_VALUE )
	UtilisateurDto findByNomUtilisateur(@PathVariable("nomUtilisateur") String nomUtilisateur);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Utilisateur/all",produces = MediaType.APPLICATION_JSON_VALUE )
    List<UtilisateurDto> findAll();
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Utilisateur/delete/id/{idUtilisateur}",produces = MediaType.APPLICATION_JSON_VALUE )
    void delete (@PathVariable("idUtilisateur") Integer id);
	
}
