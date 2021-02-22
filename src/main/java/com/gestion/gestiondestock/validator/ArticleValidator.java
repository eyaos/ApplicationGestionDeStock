package com.gestion.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gestion.gestiondestock.dto.ArticleDto;

public class ArticleValidator {
	public static List<String> validate(ArticleDto articleDto) {
		List<String> errors = new ArrayList<>();
		
		if(articleDto==null)
		{
			errors.add("veuiller saisir le code");
			errors.add("veuiller saisir la Designation");
			errors.add("veuiller saisir le Prix Unitaire HT");
			errors.add("veuiller saisir  le taux TVA");
			errors.add("veuiller selectionner une categorie");
			return errors;

		}
		
		
		if(!StringUtils.hasLength(articleDto.getCodeArticle()))
		{
			errors.add("veuiller saisir le code");
		}
		if(!StringUtils.hasLength(articleDto.getDesignation()))
		{
			errors.add("veuiller saisir la Designation");
		}
		if(articleDto.getPrixUnitaireHt()==null)
		{
			errors.add("veuiller saisir le Prix Unitaire HT");
		}
		if(articleDto.getTauxTva()==null)
		{
			errors.add("veuiller saisir le taux TVA");
		}
		if(articleDto.getCategory()==null)
		{
			errors.add("veuiller selectionner une categorie");
		}
		return errors;
	}

}
