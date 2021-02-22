package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import com.gestion.gestiondestock.dto.CommandeClientDto;


public class CommandeClientValidator {
	public static List<String> validate(CommandeClientDto commandeClientDto) {
		List<String> errors = new ArrayList<>();
		if(commandeClientDto==null) {
			return errors;
		}
		if(!StringUtils.hasLength(commandeClientDto.getCode()))
		{
			errors.add("veuiller saisir le code de la commande client");
		}
		if(!StringUtils.hasLength(commandeClientDto.getDateCommande()))
		{
			errors.add("veuiller saisir la date de la commande client");
		}
		if(commandeClientDto.getClient()==null)
		{
			errors.add("veuiller inserer le client de la commande client");
		}
		if(commandeClientDto.getLigneCommandeClient()==null)
		{
			errors.add("veuiller inserer au moin une ligne de commande de la commande client");
		}
		return errors;
	}
}
