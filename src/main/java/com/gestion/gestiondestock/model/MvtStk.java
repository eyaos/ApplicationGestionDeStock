package com.gestion.gestiondestock.model;

import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name = "mvtStk")
@EqualsAndHashCode(callSuper=true)
public class MvtStk extends AbstractEntity {
	@ManyToOne
	@JoinColumn(name = "idarticle" )
	private Article article;
	
	@Column(name = "identreprise")
	private Integer idEntreprise;
	
	@Column(name = "datemvt")
	private Instant dateMvt;
	
	@Column(name = "quantite")
	private BigDecimal quantite;
	
	@Column(name = "typemvtstk")
	private TypeMvtStk typeMvtStk ;
}
