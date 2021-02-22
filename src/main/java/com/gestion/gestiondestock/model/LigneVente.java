package com.gestion.gestiondestock.model;

import java.math.BigDecimal;

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
@Table(name = "ligneVente")
@EqualsAndHashCode(callSuper=true)
public class LigneVente extends AbstractEntity{
@ManyToOne
@JoinColumn(name = "idvente")
private Ventes vente;
@Column(name = "quantite")
private BigDecimal quantite;
@Column(name = "identreprise")
private Integer idEntreprise;

}
