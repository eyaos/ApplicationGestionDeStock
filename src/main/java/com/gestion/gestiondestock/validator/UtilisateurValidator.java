package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.UtilisateurDto;

public class UtilisateurValidator {
	public static List<String> validate(UtilisateurDto utilisateurDto) {
		List<String> errors = new ArrayList<>();
		if (utilisateurDto == null) {
			errors.add("veuiller saisir le nom de l'utilisateur");
			errors.add("veuiller saisir le prenom de l'utilisateur");
			errors.add("veuiller saisir le mot de passe de l'utilisateur");
			errors.add("veuiller saisir l'adresse de l'utilisateur");
			return errors;

		}
		if (!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("veuiller saisir le nom de l'utilisateur");
		}
		if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("veuiller saisir le prenom de l'utilisateur");
		}
		if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("veuiller saisir le mot de passe de l'utilisateur");
		}
		if (utilisateurDto.getDateDeNaissance()==null) {
			errors.add("veuiller saisir la date de naissance de l'utilisateur");
		}
		if (!StringUtils.hasLength(utilisateurDto.getMail())) {
			errors.add("veuiller saisir l'Email de l'utilisateur");
		}
		if (utilisateurDto.getAdresse() == null) {
			errors.add("veuiller saisir l'adresse de l'utilisateur");
		} else {
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
				errors.add("le champs adresse 1 est obligatoire");
			}
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
				errors.add("le champs Ville est obligatoire");
			}
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
				errors.add("le champs Code Postale est obligatoire");
			}
			if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
				errors.add("le champs Pays est obligatoire");
			}
		}
		return errors;
	}
}
