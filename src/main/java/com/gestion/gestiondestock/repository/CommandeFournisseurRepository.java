package com.gestion.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.CommandeFournisseur;

@Repository

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer>{

}
