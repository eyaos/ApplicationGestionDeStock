package com.gestion.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.Article;
import com.gestion.gestiondestock.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>{
	Optional<Utilisateur> findByNom(String nomUtilisateur);

}
