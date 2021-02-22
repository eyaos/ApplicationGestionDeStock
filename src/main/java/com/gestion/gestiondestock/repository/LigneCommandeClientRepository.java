package com.gestion.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.LigneCommandeClient;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer>{

}
