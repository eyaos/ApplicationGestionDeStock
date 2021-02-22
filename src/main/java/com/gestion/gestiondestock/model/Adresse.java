package com.gestion.gestiondestock.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {
	@Column(name = "adresse1")
	private String adresse1;
	@Column(name = "adresse2")
	private String adresse2;
	@Column(name = "ville")
	private String ville;
	@Column(name = "codePostale")
	private String codePostale;
	@Column(name = "pays")
	private String pays;
	@Column(name = "identreprise")
	private Integer idEntreprise;

}
