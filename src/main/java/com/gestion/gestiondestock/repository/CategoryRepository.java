package com.gestion.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.dto.CategoryDto;
import com.gestion.gestiondestock.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>  {
	Optional<Category> findByCode(String code);

}
