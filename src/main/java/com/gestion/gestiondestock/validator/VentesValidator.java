package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.VentesDto;

public class VentesValidator {
	public static List<String> validate(VentesDto ventesDto) {
		List<String> errors = new ArrayList<>();
		if(!StringUtils.hasLength(ventesDto.getCode()))
		{
			errors.add("veuiller saisir le code");
		}
		return errors;
	}
}
