package com.gestion.gestiondestock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gestion.gestiondestock.model.Fournisseur;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class FournisseurDto {
	
	private Integer id;

	private String nom;

	private String prenom;

	private AdresseDto adresse;

	private String photo;

	private String mail;

	private String numTel;

	private Integer idEntreprise;

	private List<CommandeFournisseurDto> cmdFournisseur;
	
	
	/*a partir d'une entité je vais construire mon dto*/
	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		if(fournisseur==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return FournisseurDto.builder()
		.id(fournisseur.getId())
		.idEntreprise(fournisseur.getIdEntreprise())
		.nom(fournisseur.getNom())
		.prenom(fournisseur.getPrenom())
		.photo(fournisseur.getPhoto())
		.mail(fournisseur.getMail())
		.numTel(fournisseur.getNumTel())
		.adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
		.cmdFournisseur(fournisseur.getCmdFournisseur()!=null? fournisseur.getCmdFournisseur().stream()
				.map(CommandeFournisseurDto::fromEntity)
				.collect(Collectors.toList()) : null)

		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
		if(fournisseurDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setIdEntreprise(fournisseurDto.getIdEntreprise());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		fournisseur.setMail(fournisseurDto.getMail());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setNumTel(fournisseurDto.getNumTel());
		fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
		fournisseur.setCmdFournisseur(fournisseurDto.getCmdFournisseur().stream()
				.map(CommandeFournisseurDto::toEntity).collect(Collectors.toList()));

		return fournisseur;
	}
}
