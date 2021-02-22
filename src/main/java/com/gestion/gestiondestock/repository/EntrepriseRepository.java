package com.gestion.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer>{
	Optional<Entreprise> findByNom(String nomEntreprise);

}
