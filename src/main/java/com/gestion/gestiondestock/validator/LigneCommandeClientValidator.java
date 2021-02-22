package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.gestion.gestiondestock.dto.LigneCommandeClientDto;

public class LigneCommandeClientValidator {
	public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {
		List<String> errors = new ArrayList<>();
if (ligneCommandeClientDto==null) {
	errors.add("veuiller saisir l'article");
	errors.add("veuiller indiquer la commande auquel appartient la ligne de commande");
	return errors;
}
		if(ligneCommandeClientDto.getArticle()==null)
		{
			errors.add("veuiller saisir l'article");
		}
		if(ligneCommandeClientDto.getCommandeClient()==null)
		{
			errors.add("veuiller indiquer la commande auquel appartient la ligne de commande");
		}
		return errors;
	}

}
