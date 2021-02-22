package com.gestion.gestiondestock.services;

import java.util.List;

import com.gestion.gestiondestock.dto.ClientDto;

public interface ClientService {
	ClientDto save(ClientDto dto);
	ClientDto findById(Integer id);
	ClientDto findByNomClient(String nomClient);
	List<ClientDto> findAll();
	void delete (Integer id);

}
