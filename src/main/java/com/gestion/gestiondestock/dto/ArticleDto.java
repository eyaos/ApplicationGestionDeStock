package com.gestion.gestiondestock.dto;

import java.math.BigDecimal;

import com.gestion.gestiondestock.model.Article;
import com.gestion.gestiondestock.model.Category;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ArticleDto {
	
	private Integer id;

	private Integer idEntreprise;

	private String codeArticle;
	
	private String designation;
	
	private BigDecimal prixUnitaireHt;

	private BigDecimal prixUnitaireTtc;
	
	private BigDecimal tauxTva;

	private String photo;
	
	private Category category;
	
	
	/*a partir d'une entité je vais construire mon dto*/
	public static ArticleDto fromEntity(Article article) {
		if(article==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return ArticleDto.builder()
		.codeArticle(article.getCodeArticle())
		.designation(article.getDesignation())
		.prixUnitaireHt(article.getPrixUnitaireHt())
		.prixUnitaireTtc(article.getPrixUnitaireTtc())
		.tauxTva(article.getTauxTva())
		.photo(article.getPhoto())
		.category(article.getCategory())
		.id(article.getId())
		.idEntreprise(article.getIdEntreprise())

		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static Article toEntity(ArticleDto articleDto) {
		if(articleDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		Article article = new Article();
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesignation(articleDto.getDesignation());
		article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
		article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
		article.setTauxTva(articleDto.getTauxTva());
		article.setPhoto(articleDto.getPhoto());
		article.setCategory(articleDto.getCategory());
		article.setId(articleDto.getId());
		article.setIdEntreprise(articleDto.getIdEntreprise());


		return article;
	}
	
}
