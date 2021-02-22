package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.gestion.gestiondestock.dto.LigneCommandeFournisseurDto;

public class LigneCommandeFournisseurValidator {
	public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		List<String> errors = new ArrayList<>();
if (ligneCommandeFournisseurDto==null) {
	errors.add("veuiller saisir l'article");
	errors.add("veuiller indiquer la commande auquel appartient la ligne de commande");	
	return errors;
}
		if(ligneCommandeFournisseurDto.getArticle()==null)
		{
			errors.add("veuiller saisir l'article");
		}
		if(ligneCommandeFournisseurDto.getCommandeFournisseur()==null)
		{
			errors.add("veuiller indiquer la commande auquel appartient la ligne de commande");
		}
		return errors;
	}
}
