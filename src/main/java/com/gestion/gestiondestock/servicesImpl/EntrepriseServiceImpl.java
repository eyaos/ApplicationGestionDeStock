package com.gestion.gestiondestock.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.gestiondestock.dto.EntrepriseDto;
import com.gestion.gestiondestock.exception.EntityNotFoundException;
import com.gestion.gestiondestock.exception.ErrorCodes;
import com.gestion.gestiondestock.exception.InvalidEntityException;
import com.gestion.gestiondestock.model.Entreprise;
import com.gestion.gestiondestock.repository.EntrepriseRepository;
import com.gestion.gestiondestock.services.EntrepriseService;
import com.gestion.gestiondestock.validator.EntrepriseValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService{
	private com.gestion.gestiondestock.repository.EntrepriseRepository EntrepriseRepository;

	public EntrepriseServiceImpl(EntrepriseRepository EntrepriseRepository) {
		super();
		this.EntrepriseRepository = EntrepriseRepository;

	}

	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
		// on verifie que l'Entreprise est valide avant de l'inserer
		List<String> errors = EntrepriseValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Entreprise non valide", dto);
			throw new InvalidEntityException("Entreprise non valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
		}
		// ici on insere dans la bd
		return EntrepriseDto.fromEntity(EntrepriseRepository.save(EntrepriseDto.toEntity(dto)));
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		if (id == null) {
			log.error("Entreprise id is null");
			return null;
		}

		Optional<Entreprise> Entreprise = EntrepriseRepository.findById(id);
		EntrepriseDto dto = EntrepriseDto.fromEntity(Entreprise.get());
		return Optional.of(dto).orElseThrow(
				() -> new EntityNotFoundException("Entreprise " + id + " not found", ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public EntrepriseDto findByNomEntreprise(String nomEntreprise) {
		if (!org.springframework.util.StringUtils.hasLength(nomEntreprise)) {
			log.error("Entreprise nom is null");
			return null;
		}

		Optional<Entreprise> Entreprise = EntrepriseRepository.findByNom(nomEntreprise);
		EntrepriseDto dto = EntrepriseDto.fromEntity(Entreprise.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Entreprise " + nomEntreprise + " not found",
				ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public List<EntrepriseDto> findAll() {
		return EntrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Entreprise id is null");
			return;
		}
		EntrepriseRepository.deleteById(id);
	}
}
