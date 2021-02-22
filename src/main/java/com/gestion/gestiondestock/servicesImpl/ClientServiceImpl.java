package com.gestion.gestiondestock.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.gestiondestock.dto.ClientDto;
import com.gestion.gestiondestock.exception.EntityNotFoundException;
import com.gestion.gestiondestock.exception.ErrorCodes;
import com.gestion.gestiondestock.exception.InvalidEntityException;
import com.gestion.gestiondestock.model.Client;
import com.gestion.gestiondestock.repository.ClientRepository;
import com.gestion.gestiondestock.services.ClientService;
import com.gestion.gestiondestock.validator.ClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService{
	private com.gestion.gestiondestock.repository.ClientRepository ClientRepository;

	public ClientServiceImpl(ClientRepository ClientRepository) {
		super();
		this.ClientRepository = ClientRepository;

	}

	@Override
	public ClientDto save(ClientDto dto) {
		// on verifie que l'Client est valide avant de l'inserer
		List<String> errors = ClientValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Client non valide", dto);
			throw new InvalidEntityException("Client non valide", ErrorCodes.CLIENT_NOT_VALID, errors);
		}
		// ici on insere dans la bd
		return ClientDto.fromEntity(ClientRepository.save(ClientDto.toEntity(dto)));
	}

	@Override
	public ClientDto findById(Integer id) {
		if (id == null) {
			log.error("Client id is null");
			return null;
		}

		Optional<Client> Client = ClientRepository.findById(id);
		ClientDto dto = ClientDto.fromEntity(Client.get());
		return Optional.of(dto).orElseThrow(
				() -> new EntityNotFoundException("Client " + id + " not found", ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public ClientDto findByNomClient(String nomClient) {
		if (!org.springframework.util.StringUtils.hasLength(nomClient)) {
			log.error("Client nom is null");
			return null;
		}

		Optional<Client> Client = ClientRepository.findByNom(nomClient);
		ClientDto dto = ClientDto.fromEntity(Client.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Client " + nomClient + " not found",
				ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public List<ClientDto> findAll() {
		return ClientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Client id is null");
			return;
		}
		ClientRepository.deleteById(id);
	}
}
