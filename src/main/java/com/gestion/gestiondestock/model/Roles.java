package com.gestion.gestiondestock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@EqualsAndHashCode(callSuper=true)
public class Roles extends AbstractEntity{
	@Column(name = "nom")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "idroles")
	private Utilisateur rolesUtilisateurs;
	
	
	@Column(name = "identreprise")
	private Integer idEntreprise;

}
 