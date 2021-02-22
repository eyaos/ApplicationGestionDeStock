package com.gestion.gestiondestock.dto;

import java.math.BigDecimal;

import com.gestion.gestiondestock.model.Article;
import com.gestion.gestiondestock.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeClientDto {
	private Integer id;
	private Article article;
	private CommandeClientDto commandeClient;
	private Integer idEntreprise;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;

	/* a partir d'une entité je vais construire mon dto */
	public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
		if (ligneCommandeClient == null) {
			return null;
		}
		/* mapping de classe vers classeDto */
		return LigneCommandeClientDto.builder()
				.article(ligneCommandeClient.getArticle())
				.id(ligneCommandeClient.getId())
				.idEntreprise(ligneCommandeClient.getIdEntreprise())
				.quantite(ligneCommandeClient.getQuantite())
				.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
				.commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient())).build();
	}

	/* a partir d'un Dto je vais construire mon entité */
	public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
		if (ligneCommandeClientDto == null) {
			return null;
		}
		/* mapping de classeDto vers classe */
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
		ligneCommandeClient.setArticle(ligneCommandeClientDto.getArticle());
		ligneCommandeClient.setId(ligneCommandeClientDto.getId());
		ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
		ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
		ligneCommandeClient.setIdEntreprise(ligneCommandeClientDto.getIdEntreprise());
		ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()));
		return ligneCommandeClient;
	}
}
