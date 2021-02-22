package com.gestion.gestiondestock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.gestion.gestiondestock.model.MvtStk;
import com.gestion.gestiondestock.model.TypeMvtStk;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MvtStkDto {
	private ArticleDto article;
	private Integer id;
	private Integer idEntreprise;
	private Instant dateMvt;
	private BigDecimal quantite;
	private TypeMvtStk typeMvtStk;

	/* a partir d'une entité je vais construire mon dto */
	public static MvtStkDto fromEntity(MvtStk mvtStk) {
		if (mvtStk == null) {
			return null;
		}
		/* mapping de classe vers classeDto */
		return MvtStkDto.builder()
				.article(ArticleDto.fromEntity(mvtStk.getArticle()))
				.id(mvtStk.getId())
				.dateMvt(mvtStk.getDateMvt())
				.quantite(mvtStk.getQuantite())
				.typeMvtStk(mvtStk.getTypeMvtStk())
				.idEntreprise(mvtStk.getIdEntreprise())
				.build();
	}

	/* a partir d'un Dto je vais construire mon entité */
	public static MvtStk toEntity(MvtStkDto mvtStkDto) {
		if (mvtStkDto == null) {
			return null;
		}
		/* mapping de classeDto vers classe */
		MvtStk mvtStk = new MvtStk();
		mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));
		mvtStk.setId(mvtStkDto.getId());
		mvtStk.setDateMvt(mvtStkDto.getDateMvt());
		mvtStk.setQuantite(mvtStkDto.getQuantite());
		mvtStk.setTypeMvtStk(mvtStkDto.getTypeMvtStk());
		mvtStk.setIdEntreprise(mvtStkDto.getIdEntreprise());
		return mvtStk;
	}
}
