package com.gestion.gestiondestock.services;

import java.util.List;

import com.gestion.gestiondestock.dto.CategoryDto;

public interface CategoryService {
	CategoryDto save(CategoryDto dto);
	CategoryDto findById(Integer id);
	List<CategoryDto> findAll();
	void delete (Integer id);
	CategoryDto findByCodeCategory(String codeCategory);

}
