package com.gestion.gestiondestock.dto;

import com.gestion.gestiondestock.model.Entreprise;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EntrepriseDto {
	private AdresseDto adresse;
	private String nom;
	private Integer id;
	private String description;
	private String codeFiscale;
	private String photo;
	private String email;
	private String numtel;

	/* a partir d'une entité je vais construire mon dto */
	public static EntrepriseDto fromEntity(Entreprise entreprise) {
		if (entreprise == null) {
			return null;
		}
		/* mapping de classe vers classeDto */
		return EntrepriseDto.builder()
				.nom(entreprise.getNom())
				.id(entreprise.getId())
				.description(entreprise.getDescription())
				.codeFiscale(entreprise.getCodeFiscale())
				.photo(entreprise.getPhoto())
				.email(entreprise.getEmail())
				.numtel(entreprise.getNumtel())
				.adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
				.build();
	}

	/* a partir d'un Dto je vais construire mon entité */
	public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
		if (entrepriseDto == null) {
			return null;
		}
		/* mapping de classeDto vers classe */
		Entreprise entreprise = new Entreprise();
		entreprise.setNom(entrepriseDto.getNom());
		entreprise.setId(entrepriseDto.getId());
		entreprise.setDescription(entrepriseDto.getDescription());
		entreprise.setCodeFiscale(entrepriseDto.getCodeFiscale());
		entreprise.setPhoto(entrepriseDto.getPhoto());
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setNumtel(entrepriseDto.getNumtel());
		entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
		return entreprise;
	}
}
