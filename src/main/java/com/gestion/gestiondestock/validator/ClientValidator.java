package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;
import com.gestion.gestiondestock.dto.ClientDto;

public class ClientValidator {
	public static List<String> validate(ClientDto clientDto) {
		List<String> errors = new ArrayList<>();
		
		if(clientDto==null)
		{
			errors.add("veuiller saisir le nom du client");
			errors.add("veuiller saisir le prenom du client");
			errors.add("veuiller saisir le mail du client");
			errors.add("veuiller saisir le numero de telephone du client");
			return errors;
		}
		if(!StringUtils.hasLength(clientDto.getNom()))
		{
			errors.add("veuiller saisir le nom du client");
		}
		if(!StringUtils.hasLength(clientDto.getPrenom()))
		{
			errors.add("veuiller saisir le prenom du client");
		}
		if(!StringUtils.hasLength(clientDto.getMail()))
		{
			errors.add("veuiller saisir le mail du client");
		}
		if(!StringUtils.hasLength(clientDto.getNumTel()))
		{
			errors.add("veuiller saisir le numero de telephone du client");
		}
		
		return errors;
	}
}
