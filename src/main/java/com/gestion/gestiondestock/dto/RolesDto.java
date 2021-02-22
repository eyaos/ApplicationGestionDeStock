package com.gestion.gestiondestock.dto;

import com.gestion.gestiondestock.model.Roles;
import com.gestion.gestiondestock.model.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class RolesDto {
	private Integer id;
	private Integer idEntreprise;
	private String nom;
	private Utilisateur rolesUtilisateurs;

	/*a partir d'une entité je vais construire mon dto*/
	public static RolesDto fromEntity(Roles roles) {
		if(roles==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return RolesDto.builder()
		.nom(roles.getNom())
		.id(roles.getId())
		.idEntreprise(roles.getIdEntreprise())
	    .rolesUtilisateurs(roles.getRolesUtilisateurs())

		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static Roles toEntity(RolesDto rolesDto) {
		if(rolesDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		Roles roles = new Roles();
		roles.setId(rolesDto.getId());
		roles.setIdEntreprise(rolesDto.getIdEntreprise());
		roles.setNom(rolesDto.getNom());
		roles.setRolesUtilisateurs(rolesDto.getRolesUtilisateurs());


		return roles;
	}
}
