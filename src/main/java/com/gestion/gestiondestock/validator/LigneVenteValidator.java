package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.gestion.gestiondestock.dto.LigneVenteDto;

public class LigneVenteValidator {
	public static List<String> validate(LigneVenteDto ligneVenteDto) {
		List<String> errors = new ArrayList<>();
		if(ligneVenteDto==null)
		{
			errors.add("veuiller saisir la quantité");
			errors.add("veuiller selectionner la vente");
			return errors;
		}
		if(ligneVenteDto.getQuantite()==null) {
			errors.add("veuiller saisir la quantité");
		}
		if(ligneVenteDto.getVente()==null) {
			errors.add("veuiller selectionner la vente");
		}
		return errors;
	}
}
