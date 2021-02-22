package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.CategoryDto;

public class CategoryValidator {

	public static List<String> validate(CategoryDto categoryDto) {
		List<String> errors = new ArrayList<>();
		if(categoryDto==null||!StringUtils.hasLength(categoryDto.getCode()))
		{
			errors.add("veuiller saisir le code");
		}
		return errors;
	}
}
