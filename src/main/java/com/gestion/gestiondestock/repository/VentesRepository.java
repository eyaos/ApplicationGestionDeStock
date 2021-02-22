package com.gestion.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.Ventes;

@Repository
public interface VentesRepository extends JpaRepository<Ventes,Integer>{

}
