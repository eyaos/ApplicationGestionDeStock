package com.gestion.gestiondestock.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestion.gestiondestock.dto.CategoryDto;

public interface CategoryApi {
	@PostMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Category/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	CategoryDto save( @RequestBody CategoryDto dto);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Category/id/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE )
	CategoryDto findById(@PathVariable("idCategory") Integer id);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Category/code/{codeCategory}",produces = MediaType.APPLICATION_JSON_VALUE )
	CategoryDto findByCodeCategory(@PathVariable("codeCategory") String codeCategory);
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Category/all",produces = MediaType.APPLICATION_JSON_VALUE )
    List<CategoryDto> findAll();
	@GetMapping(value = com.gestion.gestiondestock.utils.Constants.APPROOT +"/Category/delete/id/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE )
    void delete (@PathVariable("idCategory") Integer id);
	
}
