package com.gestion.gestiondestock.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ventes")
@EqualsAndHashCode(callSuper = true)
public class Ventes extends AbstractEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "datevente")
	private Instant dateVente;

	@Column(name = "commentaire")
	private String commentaire;

	@Column(name = "identreprise")
	private Integer idEntreprise;

}
