package com.gestion.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestiondestock.api.ClientApi;
import com.gestion.gestiondestock.dto.ClientDto;
import com.gestion.gestiondestock.services.ClientService;

@RestController
public class ClientController implements ClientApi{
	@Autowired
	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public ClientDto save(ClientDto dto) {
		return clientService.save(dto);
	}

	@Override
	public ClientDto findById(Integer id) {
		return clientService.findById(id);
	}

	@Override
	public ClientDto findByNomClient(String nomClient) {
		return clientService.findByNomClient(nomClient);
	}

	@Override
	public List<ClientDto> findAll() {
		return clientService.findAll();
	}

	@Override
	public void delete(Integer id) {
		clientService.delete(id);
	}
}
