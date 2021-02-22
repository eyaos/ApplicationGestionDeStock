package com.gestion.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer>{
	Optional<Fournisseur> findByNom(String nomFournisseur);

}
