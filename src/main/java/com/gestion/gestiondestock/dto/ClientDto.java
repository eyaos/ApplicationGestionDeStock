package com.gestion.gestiondestock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestion.gestiondestock.model.Client;

import lombok.Builder;
import lombok.Data;
@Builder
@Data

public class ClientDto {
	
	private Integer id;

	private String nom;

	private String prenom;

	private AdresseDto adresse;

	private String photo;

	private String mail;

	private String numTel;
	private Integer idEntreprise;

	@JsonIgnore
	private List<CommandeClientDto> cmdClient;
	
	/*a partir d'une entité je vais construire mon dto*/
	public static ClientDto fromEntity(Client client) {
		if(client==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return ClientDto.builder()
		.id(client.getId())
		.idEntreprise(client.getIdEntreprise())
		.nom(client.getNom())
		.prenom(client.getPrenom())
		.photo(client.getPhoto())
		.mail(client.getMail())
		.numTel(client.getNumTel())
		.adresse(AdresseDto.fromEntity(client.getAdresse()))
		.cmdClient(client.getCmdClient()!=null? client.getCmdClient().stream()
				.map(CommandeClientDto::fromEntity)
				.collect(Collectors.toList()) : null)

		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static Client toEntity(ClientDto clientDto) {
		if(clientDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		Client client = new Client();
		client.setId(clientDto.getId());
		client.setIdEntreprise(clientDto.getIdEntreprise());
		client.setNom(clientDto.getNom());
		client.setPrenom(clientDto.getPrenom());
		client.setMail(clientDto.getMail());
		client.setPhoto(clientDto.getPhoto());
		client.setNumTel(clientDto.getNumTel());
		client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
		client.setCmdClient(clientDto.getCmdClient().stream()
				.map(CommandeClientDto::toEntity).collect(Collectors.toList()));

		return client;
	}
}
