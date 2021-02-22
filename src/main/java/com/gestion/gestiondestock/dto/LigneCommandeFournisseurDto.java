package com.gestion.gestiondestock.dto;

import java.math.BigDecimal;

import com.gestion.gestiondestock.model.Article;
import com.gestion.gestiondestock.model.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeFournisseurDto {
	private Article article;
	private CommandeFournisseurDto commandeFournisseur;
	private Integer id;
	private Integer idEntreprise;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;

	/* a partir d'une entité je vais construire mon dto */
	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
		if (ligneCommandeFournisseur == null) {
			return null;
		}
		/* mapping de classe vers classeDto */
		return LigneCommandeFournisseurDto.builder()
				.article(ligneCommandeFournisseur.getArticle())
				.id(ligneCommandeFournisseur.getId())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
				.commandeFournisseur(
						CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
				.build();
	}

	/* a partir d'un Dto je vais construire mon entité */
	public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		if (ligneCommandeFournisseurDto == null) {
			return null;
		}
		/* mapping de classeDto vers classe */
		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setArticle(ligneCommandeFournisseurDto.getArticle());
		ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
		ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseurDto.getIdEntreprise());
		ligneCommandeFournisseur.setCommandeFournisseur(
				CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseur()));
		return ligneCommandeFournisseur;
	}
}
