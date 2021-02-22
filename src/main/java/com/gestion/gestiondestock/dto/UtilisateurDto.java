package com.gestion.gestiondestock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.gestion.gestiondestock.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class UtilisateurDto {
	private Integer id;

	private String nom;
	
	private String prenom;
	
	private String motDePasse;
	
	private AdresseDto adresse;

	private String photo;

	private String mail;
	
	private Instant dateDeNaissance;
	
	private EntrepriseDto entreprise;
	
    private List<RolesDto> rolesUtilisateurs;
    
	/*a partir d'une entité je vais construire mon dto*/
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
		if(utilisateur==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return UtilisateurDto.builder()
		.id(utilisateur.getId())
		.nom(utilisateur.getNom())
		.prenom(utilisateur.getPrenom())
		.photo(utilisateur.getPhoto())
		.mail(utilisateur.getMail())
		.motDePasse(utilisateur.getMotDePasse())
		.dateDeNaissance(utilisateur.getDateDeNaissance())
		.entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
		.adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
		.rolesUtilisateurs(utilisateur.getRolesUtilisateurs()!=null? utilisateur.getRolesUtilisateurs().stream()
				.map(RolesDto::fromEntity)
				.collect(Collectors.toList()) : null)
		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
		if(utilisateurDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(utilisateurDto.getId());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setPhoto(utilisateurDto.getPhoto());
		utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
		utilisateur.setMail(utilisateurDto.getMail());
		
		utilisateur.setRolesUtilisateurs(utilisateurDto.getRolesUtilisateurs().stream()
				.map(RolesDto::toEntity).collect(Collectors.toList()));
		utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
		utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
		utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));

		return utilisateur;
	}
}
