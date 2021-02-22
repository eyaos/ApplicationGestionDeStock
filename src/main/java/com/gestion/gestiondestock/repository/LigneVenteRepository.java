package com.gestion.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.LigneVente;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer>{

}
