package com.gestion.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.Client;
@Repository

public interface ClientRepository extends JpaRepository<Client,Integer> {
	Optional<Client> findByNom(String nomClient);

}
