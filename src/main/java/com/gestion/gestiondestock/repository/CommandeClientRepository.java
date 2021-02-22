package com.gestion.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.CommandeClient;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {

}
