package com.gestion.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestiondestock.model.MvtStk;

@Repository
public interface MvtStkRepository extends JpaRepository<MvtStk,Integer>{

}
