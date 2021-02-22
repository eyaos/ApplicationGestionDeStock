package com.gestion.gestiondestock.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.gestiondestock.dto.EntrepriseDto;

public interface EntrepriseApi {
	@PostMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Entreprise/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	EntrepriseDto save( @RequestBody EntrepriseDto dto);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Entreprise/id/{idEntreprise}",produces = MediaType.APPLICATION_JSON_VALUE )
	EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Entreprise/nom/{nomEntreprise}",produces = MediaType.APPLICATION_JSON_VALUE )
	EntrepriseDto findByNomEntreprise(@PathVariable("nomEntreprise") String nomEntreprise);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE )
    List<EntrepriseDto> findAll();
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Entreprise/delete/id/{idEntreprise}",produces = MediaType.APPLICATION_JSON_VALUE )
    void delete (@PathVariable("idEntreprise") Integer id);
}
