package com.gestion.gestiondestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestiondestock.api.ArticleApi;
import com.gestion.gestiondestock.dto.ArticleDto;
import com.gestion.gestiondestock.services.ArticleService;

@RestController
public class ArticleController implements ArticleApi {

	@Autowired
	private ArticleService articleService;

	@Autowired
// cette annotation permet de creer automatiquement des instances 3 types
//field ijection : je met l'annotation au niveau du champ ou variable
//constructor injection  : on vas injecter les dependences au niveau du constructeur
//getter injection : j'aoute l'annotation a un getter exp : @autowired ... puclic .. getArticle....

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public ArticleDto save(ArticleDto dto) {
		return articleService.save(dto);
	}

	@Override
	public ArticleDto findById(Integer id) {
		return articleService.findById(id);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		return articleService.findByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleService.findAll();
	}

	@Override
	public void delete(Integer id) {
		articleService.delete(id);
	}

}
