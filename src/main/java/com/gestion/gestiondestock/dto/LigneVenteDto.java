package com.gestion.gestiondestock.dto;

import java.math.BigDecimal;

import com.gestion.gestiondestock.model.LigneVente;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class LigneVenteDto {
	private VentesDto vente;
	private BigDecimal quantite;
	private Integer id;
	private Integer idEntreprise;

	/*a partir d'une entité je vais construire mon dto*/
	public static LigneVenteDto fromEntity(LigneVente LigneVente) {
		if(LigneVente==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return LigneVenteDto.builder()
        .id(LigneVente.getId())
        .idEntreprise(LigneVente.getIdEntreprise())
		.quantite(LigneVente.getQuantite())
		.vente(VentesDto.fromEntity(LigneVente.getVente()))
		
		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static LigneVente toEntity(LigneVenteDto LigneVenteDto) {
		if(LigneVenteDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		LigneVente LigneVente = new LigneVente();
		LigneVente.setId(LigneVenteDto.getId());
		LigneVente.setIdEntreprise(LigneVenteDto.getIdEntreprise());
		LigneVente.setVente(VentesDto.toEntity(LigneVenteDto.getVente()));
		LigneVente.setQuantite(LigneVenteDto.getQuantite());
		
		return LigneVente;
	}
}
