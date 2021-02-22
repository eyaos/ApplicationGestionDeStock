package com.gestion.gestiondestock.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.gestiondestock.dto.ClientDto;

public interface ClientApi {
	@PostMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Client/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	ClientDto save( @RequestBody ClientDto dto);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Client/id/{idClient}",produces = MediaType.APPLICATION_JSON_VALUE )
	ClientDto findById(@PathVariable("idClient") Integer id);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Client/nom/{nomClient}",produces = MediaType.APPLICATION_JSON_VALUE )
	ClientDto findByNomClient(@PathVariable("nomClient") String nomClient);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Client/all",produces = MediaType.APPLICATION_JSON_VALUE )
    List<ClientDto> findAll();
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Client/delete/id/{idClient}",produces = MediaType.APPLICATION_JSON_VALUE )
    void delete (@PathVariable("idClient") Integer id);
}
