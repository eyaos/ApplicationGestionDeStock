package com.gestion.gestiondestock.dto;

import com.gestion.gestiondestock.model.Adresse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AdresseDto {
private String adresse1;
private String adresse2;
private String ville;
private String codePostale;
private String pays;

/*a partir d'une entité je vais construire mon dto*/
public static AdresseDto fromEntity(Adresse adresse) {
	if(adresse==null) {
		return null;
	}
	/* mapping de classe vers classeDto*/
	return AdresseDto.builder()
			.adresse1(adresse.getAdresse1())
			.adresse2(adresse.getAdresse2())
			.ville(adresse.getVille())
			.codePostale(adresse.getCodePostale())
			.pays(adresse.getPays())

	.build();
}
/*a partir d'un Dto je vais construire mon entité*/
public static Adresse toEntity(AdresseDto adresseDto) {
	if(adresseDto==null) {
		return null;
	}
	/* mapping de classeDto vers classe*/
	Adresse adresse = new Adresse();
	adresse.setAdresse1(adresseDto.getAdresse1());
	adresse.setAdresse2(adresseDto.getAdresse2());
	adresse.setCodePostale(adresseDto.getCodePostale());
	adresse.setPays(adresseDto.getPays());
	adresse.setVille(adresseDto.getVille());

	return adresse;
}

}
