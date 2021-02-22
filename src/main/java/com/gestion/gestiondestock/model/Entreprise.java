package com.gestion.gestiondestock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity {
	@Embedded
	private Adresse adresse;
	@Column(name = "nom")
	private String nom;

	@Column(name = "description")
	private String description;

	@Column(name = "codefiscale")
	private String codeFiscale;

	@Column(name = "photo")
	private String photo;

	@Column(name = "email")
	private String email;

	@Column(name = "numtel")
	private String numtel;
	
	@OneToMany(mappedBy="entreprise")
	private List<Utilisateur> entUser;

}
