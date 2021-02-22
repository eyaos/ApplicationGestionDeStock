package com.gestion.gestiondestock.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestion.gestiondestock.dto.ArticleDto;
import com.gestion.gestiondestock.exception.EntityNotFoundException;
import com.gestion.gestiondestock.exception.ErrorCodes;
import com.gestion.gestiondestock.exception.InvalidEntityException;
import com.gestion.gestiondestock.model.Article;
import com.gestion.gestiondestock.repository.ArticleRepository;
import com.gestion.gestiondestock.services.ArticleService;
import com.gestion.gestiondestock.validator.ArticleValidator;

import antlr.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Service("ArticleServiceImpl1")
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;

	}

	@Override
	public ArticleDto save(ArticleDto dto) {
		// on verifie que l'article est valide avant de l'inserer
		List<String> errors = ArticleValidator.validate(dto);
		if (!errors.isEmpty()) {
			log.error("Article non valide", dto);
			throw new InvalidEntityException("Article non valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}
		// ici on insere dans la bd
		return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
	}

	@Override
	public ArticleDto findById(Integer id) {
		if (id == null) {
			log.error("article id is null");
			return null;
		}

		Optional<Article> article = articleRepository.findById(id);
		ArticleDto dto = ArticleDto.fromEntity(article.get());
		return Optional.of(dto).orElseThrow(
				() -> new EntityNotFoundException("Article " + id + " not found", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if (!org.springframework.util.StringUtils.hasLength(codeArticle)) {
			log.error("article Code is null");
			return null;
		}

		Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);
		ArticleDto dto = ArticleDto.fromEntity(article.get());
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Article " + codeArticle + " not found",
				ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDto> findAll() {
		return articleRepository.findAll().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("article id is null");
			return;
		}
		articleRepository.deleteById(id);
	}

}
