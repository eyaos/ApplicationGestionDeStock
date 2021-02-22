package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.gestion.gestiondestock.dto.MvtStkDto;

public class MvtStkValidator {
	public static List<String> validate(MvtStkDto mvtStkDto) {
		List<String> errors = new ArrayList<>();
		if(mvtStkDto==null||mvtStkDto.getArticle()==null)
		{
			errors.add("veuiller Ajouter des articles");
		}
		return errors;
	}
}
