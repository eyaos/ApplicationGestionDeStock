package com.gestion.gestiondestock.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion.gestiondestock.dto.ArticleDto;

public interface ArticleApi {
	@PostMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Article/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	ArticleDto save( @RequestBody ArticleDto dto);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Article/id/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE )
	ArticleDto findById(@PathVariable("idArticle") Integer id);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Article/code/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE )
	ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Article/all",produces = MediaType.APPLICATION_JSON_VALUE )
    List<ArticleDto> findAll();
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Article/delete/id/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE )
    void delete (@PathVariable("idArticle") Integer id);
	
}
