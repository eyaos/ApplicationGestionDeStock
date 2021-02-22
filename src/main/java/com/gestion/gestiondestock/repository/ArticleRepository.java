package com.gestion.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {
	Optional<Article> findByCodeArticle(String codeArticle);
//	// c'est une requete jipituel
//	// spring vas faire le mapping entre le code et la bd
//	@Query("select * from article where codearticle=:code and designation =: designation")
//	List<Article> findByCustomQuery(@Param("code") String c, @Param("designation") String d);
//
//    //une requete native
//	@Query(value = "select * from article where codearticle=:code", nativeQuery = true)
//	List<Article> findByCustomNativeQuery(@Param("code") String c, @Param("designation") String d);
//
//	List<Article> findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codearticle, String designation);
}
