package com.gestion.gestiondestock.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.gestiondestock.dto.FournisseurDto;
import com.gestion.gestiondestock.exception.EntityNotFoundException;
import com.gestion.gestiondestock.exception.ErrorCodes;
import com.gestion.gestiondestock.exception.InvalidEntityException;
import com.gestion.gestiondestock.model.Fournisseur;
import com.gestion.gestiondestock.repository.FournisseurRepository;
import com.gestion.gestiondestock.services.FournisseurService;
import com.gestion.gestiondestock.validator.FournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService{
	private com.gestion.gestiondestock.repository.FournisseurRepository FournisseurRepository;

	public FournisseurServiceImpl(FournisseurRepository FournisseurRepository) {
		super();
		this.FournisseurRepository = FournisseurRepository;

	}

	@Override
	public FournisseurDto save(FournisseurDto dto) {
		// on verifie que l'Fournisseur est valide avant de l'inserer
		List<String> errors = FournisseurValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Fournisseur non valide", dto);
			throw new InvalidEntityException("Fournisseur non valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
		}
		// ici on insere dans la bd
		return FournisseurDto.fromEntity(FournisseurRepository.save(FournisseurDto.toEntity(dto)));
	}

	@Override
	public FournisseurDto findById(Integer id) {
		if (id == null) {
			log.error("Fournisseur id is null");
			return null;
		}

		Optional<Fournisseur> Fournisseur = FournisseurRepository.findById(id);
		FournisseurDto dto = FournisseurDto.fromEntity(Fournisseur.get());
		return Optional.of(dto).orElseThrow(
				() -> new EntityNotFoundException("Fournisseur " + id + " not found", ErrorCodes.FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public FournisseurDto findByNomFournisseur(String nomFournisseur) {
		if (!org.springframework.util.StringUtils.hasLength(nomFournisseur)) {
			log.error("Fournisseur nom is null");
			return null;
		}

		Optional<Fournisseur> Fournisseur = FournisseurRepository.findByNom(nomFournisseur);
		FournisseurDto dto = FournisseurDto.fromEntity(Fournisseur.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Fournisseur " + nomFournisseur + " not found",
				ErrorCodes.FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public List<FournisseurDto> findAll() {
		return FournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Fournisseur id is null");
			return;
		}
		FournisseurRepository.deleteById(id);
	}
}
