package com.gestion.gestiondestock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "commandeFournisseur")
@EqualsAndHashCode(callSuper=true)

public class CommandeFournisseur extends AbstractEntity{
	@Column(name = "code")
	private String code;
	
	@Column(name = "datecommande")
	private String dateCommande;

	@ManyToOne
	@JoinColumn(name="idfournisseur")
	private Fournisseur fournisseur;
	
	@Column(name = "identreprise")
	private Integer idEntreprise;

	@OneToMany(mappedBy = "commandeFournisseur")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseur;

}
