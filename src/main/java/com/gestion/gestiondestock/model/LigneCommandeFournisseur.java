package com.gestion.gestiondestock.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ligneCommandeFournisseur")
@EqualsAndHashCode(callSuper=true)
public class LigneCommandeFournisseur extends AbstractEntity{
	@ManyToOne
	@JoinColumn(name = "idarticle" )
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "idcommandefournisseur" )
	private CommandeFournisseur commandeFournisseur;
	
	@Column(name = "quantite")
	private BigDecimal quantite;
	
	@Column(name = "prixunitaire")
	private BigDecimal prixUnitaire;
	
	@Column(name = "identreprise")
	private Integer idEntreprise;

}
