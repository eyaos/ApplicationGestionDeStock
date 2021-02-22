package com.gestion.gestiondestock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "commandeClient")
@EqualsAndHashCode(callSuper = true)

public class CommandeClient extends AbstractEntity {

	@Column(name = "code")
	private String code;
	
	@Column(name = "datecommande")
	private String dateCommande;

	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;
	
	@Column(name = "identreprise")
	private Integer idEntreprise;

	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClient;
	
}
