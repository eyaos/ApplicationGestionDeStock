package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.RolesDto;

public class RolesValidator {
	public static List<String> validate(RolesDto rolesDto) {
		List<String> errors = new ArrayList<>();
		if(!StringUtils.hasLength(rolesDto.getNom()))
		{
			errors.add("veuiller saisir le nom");
		}
		return errors;
	}
}
