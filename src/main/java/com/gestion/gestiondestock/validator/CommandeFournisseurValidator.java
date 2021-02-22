package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.CommandeFournisseurDto;

public class CommandeFournisseurValidator {
	public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
		List<String> errors = new ArrayList<>();
		if(commandeFournisseurDto==null) {
			return errors;
		}
		if(!StringUtils.hasLength(commandeFournisseurDto.getCode()))
		{
			errors.add("veuiller saisir le code de la commande fournisseur");
		}
		if(!StringUtils.hasLength(commandeFournisseurDto.getDateCommande()))
		{
			errors.add("veuiller saisir la date de la commande fournisseur");
		}
		if(commandeFournisseurDto.getFournisseur()==null)
		{
			errors.add("veuiller inserer le Fournisseur de la commande fournisseur");
		}
		if(commandeFournisseurDto.getLigneCommandeFournisseur()==null)
		{			errors.add("veuiller inserer au moin une ligne de commande");

		}
		return errors;
	}
}
