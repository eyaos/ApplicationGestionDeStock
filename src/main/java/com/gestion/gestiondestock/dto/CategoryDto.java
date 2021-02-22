package com.gestion.gestiondestock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gestion.gestiondestock.model.Category;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CategoryDto {
	private Integer id;
	private Integer idEntreprise;
	private String code;
	private String designation;
	//@JsonIgnore
	private List<ArticleDto> articles;
	
	
	/*a partir d'une entité je vais construire mon dto*/
	public static CategoryDto fromEntity(Category category) {
		if(category==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return CategoryDto.builder()
		.id(category.getId())
		.idEntreprise(category.getIdEntreprise())
		.code(category.getCode())
		.designation(category.getDesignation())
		.articles(category.getArticles()!=null? category.getArticles().stream()
				.map(ArticleDto::fromEntity)
				.collect(Collectors.toList()) : null)
		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static Category toEntity(CategoryDto categoryDto) {
		if(categoryDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		Category category = new Category();
		category.setId(categoryDto.getId());
		category.setIdEntreprise(categoryDto.getIdEntreprise());
		category.setCode(categoryDto.getCode());
		category.setDesignation(categoryDto.getDesignation());
		category.setArticles(categoryDto.getArticles().stream()
				.map(ArticleDto::toEntity).collect(Collectors.toList()));

		return category;
	}
}
