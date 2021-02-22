package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.FournisseurDto;


public class FournisseurValidator {
	public static List<String> validate(FournisseurDto fournisseurDto) {
		List<String> errors = new ArrayList<>();
		
		if(fournisseurDto==null)
		{
			errors.add("veuiller saisir le nom du fournisseur");
			errors.add("veuiller saisir le prenom du fournisseur");
			errors.add("veuiller saisir le mail du fournisseur");
			errors.add("veuiller saisir le numero de telephone du fournisseur");
			return errors;
		}
		if(!StringUtils.hasLength(fournisseurDto.getNom()))
		{
			errors.add("veuiller saisir le nom du fournisseur");
		}
		if(!StringUtils.hasLength(fournisseurDto.getPrenom()))
		{
			errors.add("veuiller saisir le prenom du fournisseur");
		}
		if(!StringUtils.hasLength(fournisseurDto.getMail()))
		{
			errors.add("veuiller saisir le mail du fournisseur");
		}
		if(!StringUtils.hasLength(fournisseurDto.getNumTel()))
		{
			errors.add("veuiller saisir le numero de telephone du fournisseur");
		}
		
		return errors;
	}
}
