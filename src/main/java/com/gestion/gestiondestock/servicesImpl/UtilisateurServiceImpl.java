package com.gestion.gestiondestock.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.gestiondestock.dto.UtilisateurDto;
import com.gestion.gestiondestock.exception.EntityNotFoundException;
import com.gestion.gestiondestock.exception.ErrorCodes;
import com.gestion.gestiondestock.exception.InvalidEntityException;
import com.gestion.gestiondestock.model.Utilisateur;
import com.gestion.gestiondestock.repository.UtilisateurRepository;
import com.gestion.gestiondestock.services.UtilisateurService;
import com.gestion.gestiondestock.validator.UtilisateurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService{
	private com.gestion.gestiondestock.repository.UtilisateurRepository UtilisateurRepository;

	public UtilisateurServiceImpl(UtilisateurRepository UtilisateurRepository) {
		super();
		this.UtilisateurRepository = UtilisateurRepository;

	}

	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		// on verifie que l'Utilisateur est valide avant de l'inserer
		List<String> errors = UtilisateurValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Utilisateur non valide", dto);
			throw new InvalidEntityException("Utilisateur non valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
		}
		// ici on insere dans la bd
		return UtilisateurDto.fromEntity(UtilisateurRepository.save(UtilisateurDto.toEntity(dto)));
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		if (id == null) {
			log.error("Utilisateur id is null");
			return null;
		}

		Optional<Utilisateur> Utilisateur = UtilisateurRepository.findById(id);
		UtilisateurDto dto = UtilisateurDto.fromEntity(Utilisateur.get());
		return Optional.of(dto).orElseThrow(
				() -> new EntityNotFoundException("Utilisateur " + id + " not found", ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public UtilisateurDto findByNomUtilisateur(String nomUtilisateur) {
		if (!org.springframework.util.StringUtils.hasLength(nomUtilisateur)) {
			log.error("Utilisateur nom is null");
			return null;
		}

		Optional<Utilisateur> Utilisateur = UtilisateurRepository.findByNom(nomUtilisateur);
		UtilisateurDto dto = UtilisateurDto.fromEntity(Utilisateur.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Utilisateur " + nomUtilisateur + " not found",
				ErrorCodes.UTILISATEUR_NOT_FOUND));
	}

	@Override
	public List<UtilisateurDto> findAll() {
		return UtilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Utilisateur id is null");
			return;
		}
		UtilisateurRepository.deleteById(id);
	}
}
