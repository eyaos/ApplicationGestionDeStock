package com.gestion.gestiondestock.dto;

import java.time.Instant;

import com.gestion.gestiondestock.model.Ventes;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VentesDto {
	private String code;
	private Integer id;
	private Integer idEntreprise;
	private Instant dateVente;
	private String commentaire;

	/* a partir d'une entité je vais construire mon dto */
	public static VentesDto fromEntity(Ventes ventes) {
		if (ventes == null) {
			return null;
		}
		/* mapping de classe vers classeDto */
		return VentesDto.builder()
				.id(ventes.getId())
				.idEntreprise(ventes.getIdEntreprise())
				.code(ventes.getCode())
				.dateVente(ventes.getDateVente())
				.commentaire(ventes.getCommentaire())
				.build();
	}

	/* a partir d'un Dto je vais construire mon entité */
	public static Ventes toEntity(VentesDto ventesDto) {
		if (ventesDto == null) {
			return null;
		}
		/* mapping de classeDto vers classe */
		Ventes ventes = new Ventes();
		ventes.setCode(ventesDto.getCode());
		ventes.setId(ventesDto.getId());
		ventes.setDateVente(ventesDto.getDateVente());
		ventes.setCommentaire(ventesDto.getCommentaire());
		ventes.setIdEntreprise(ventesDto.getIdEntreprise());

		return ventes;
	}
}
