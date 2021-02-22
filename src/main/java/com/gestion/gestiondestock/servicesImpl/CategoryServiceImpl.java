package com.gestion.gestiondestock.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.gestiondestock.dto.CategoryDto;
import com.gestion.gestiondestock.exception.EntityNotFoundException;
import com.gestion.gestiondestock.exception.ErrorCodes;
import com.gestion.gestiondestock.exception.InvalidEntityException;
import com.gestion.gestiondestock.model.Category;
import com.gestion.gestiondestock.repository.CategoryRepository;
import com.gestion.gestiondestock.services.CategoryService;
import com.gestion.gestiondestock.validator.CategoryValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService{

	private com.gestion.gestiondestock.repository.CategoryRepository CategoryRepository;

	public CategoryServiceImpl(CategoryRepository CategoryRepository) {
		super();
		this.CategoryRepository = CategoryRepository;

	}

	@Override
	public CategoryDto save(CategoryDto dto) {
		// on verifie que l'Category est valide avant de l'inserer
		List<String> errors = CategoryValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Category non valide", dto);
			throw new InvalidEntityException("Category non valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
		}
		// ici on insere dans la bd
		return CategoryDto.fromEntity(CategoryRepository.save(CategoryDto.toEntity(dto)));
	}

	@Override
	public CategoryDto findById(Integer id) {
		if (id == null) {
			log.error("Category id is null");
			return null;
		}

		Optional<Category> Category = CategoryRepository.findById(id);
		CategoryDto dto = CategoryDto.fromEntity(Category.get());
		return Optional.of(dto).orElseThrow(
				() -> new EntityNotFoundException("Category " + id + " not found", ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public CategoryDto findByCodeCategory(String codeCategory) {
		if (!org.springframework.util.StringUtils.hasLength(codeCategory)) {
			log.error("Category Code is null");
			return null;
		}

		Optional<Category> Category = CategoryRepository.findByCode(codeCategory);
		CategoryDto dto = CategoryDto.fromEntity(Category.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Category " + codeCategory + " not found",
				ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public List<CategoryDto> findAll() {
		return CategoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Category id is null");
			return;
		}
		CategoryRepository.deleteById(id);
	}
}
