package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.EntrepriseDto;

public class EntrepriseValidator {
	
	public static List<String> validate(EntrepriseDto entrepriseDto) {
		List<String> errors = new ArrayList<>();
		
		if(entrepriseDto==null)
		{
			errors.add("veuiller saisir le nom du l'entreprise");
			errors.add("veuiller saisir l'adresse de l'utilisateur");

			return errors;
		}
		if(!StringUtils.hasLength(entrepriseDto.getNom()))
		{
			errors.add("veuiller saisir le nom du l'entreprise");
		}
		if (entrepriseDto.getAdresse() == null) {
			errors.add("veuiller saisir l'adresse de l'utilisateur");
		} else {
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse1())) {
				errors.add("le champs adresse 1 est obligatoire");
			}
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getVille())) {
				errors.add("le champs Ville est obligatoire");
			}
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getCodePostale())) {
				errors.add("le champs Code Postale est obligatoire");
			}
			if (!StringUtils.hasLength(entrepriseDto.getAdresse().getPays())) {
				errors.add("le champs Pays est obligatoire");
			}
			}
		return errors;

}
	}
