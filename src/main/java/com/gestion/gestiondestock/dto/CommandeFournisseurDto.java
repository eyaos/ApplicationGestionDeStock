package com.gestion.gestiondestock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gestion.gestiondestock.model.CommandeFournisseur;

import lombok.Builder;
import lombok.Data;
@Builder
@Data

public class CommandeFournisseurDto {
	private String code;
	private Integer id;
	private Integer idEntreprise;
	private String dateCommande;
	private FournisseurDto fournisseur;
	
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseur;
	
	
	/*a partir d'une entité je vais construire mon dto*/
	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
		if(commandeFournisseur==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return CommandeFournisseurDto.builder()
		.code(commandeFournisseur.getCode())
		.id(commandeFournisseur.getId())
		.idEntreprise(commandeFournisseur.getIdEntreprise())
		.dateCommande(commandeFournisseur.getDateCommande())
		.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
		.ligneCommandeFournisseur(commandeFournisseur.getLigneCommandeFournisseur()!=null? commandeFournisseur.getLigneCommandeFournisseur().stream()
				.map(LigneCommandeFournisseurDto::fromEntity)
				.collect(Collectors.toList()) : null)
		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
		if(commandeFournisseurDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
		commandeFournisseur.setCode(commandeFournisseurDto.getCode());
		commandeFournisseur.setId(commandeFournisseurDto.getId());
		commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));	
		commandeFournisseur.setLigneCommandeFournisseur(commandeFournisseurDto.getLigneCommandeFournisseur().stream()
				.map(LigneCommandeFournisseurDto::toEntity).collect(Collectors.toList()));

		return commandeFournisseur;
	}
}
