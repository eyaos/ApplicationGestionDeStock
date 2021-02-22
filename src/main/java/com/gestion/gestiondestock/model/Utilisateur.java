package com.gestion.gestiondestock.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
@EqualsAndHashCode(callSuper=true)
public class Utilisateur extends AbstractEntity{
	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "motdepasse")
	private String motDePasse;
	
	@Column(name = "adresse")
	private Adresse adresse;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "datedenaissance")
	private Instant dateDeNaissance;
	
@ManyToOne
@JoinColumn(name = "identreprise", insertable = false, updatable = false)
private Entreprise entreprise;
	
	@OneToMany(mappedBy = "rolesUtilisateurs")
    private List<Roles> rolesUtilisateurs;
}
