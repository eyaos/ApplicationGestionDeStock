package com.gestion.gestiondestock.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gestion.gestiondestock.model.CommandeClient;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CommandeClientDto {
	private String code;
	private Integer id;
	private Integer idEntreprise;
	private String dateCommande;
	private ClientDto client;
	
	private List<LigneCommandeClientDto> ligneCommandeClient;


	/*a partir d'une entité je vais construire mon dto*/
	public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
		if(commandeClient==null) {
			return null;
		}
		/* mapping de classe vers classeDto*/
		return CommandeClientDto.builder()
		.id(commandeClient.getId())
		.idEntreprise(commandeClient.getIdEntreprise())
		.code(commandeClient.getCode())
		.dateCommande(commandeClient.getDateCommande())
		.client(ClientDto.fromEntity(commandeClient.getClient()))
		.ligneCommandeClient(commandeClient.getLigneCommandeClient()!=null? commandeClient.getLigneCommandeClient().stream()
				.map(LigneCommandeClientDto::fromEntity)
				.collect(Collectors.toList()) : null)
		.build();
	}
	/*a partir d'un Dto je vais construire mon entité*/
	public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
		if(commandeClientDto==null) {
			return null;
		}
		/* mapping de classeDto vers classe*/
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setCode(commandeClientDto.getCode());
		commandeClient.setId(commandeClientDto.getId());
		commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
		commandeClient.setDateCommande(commandeClientDto.getDateCommande());
		commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
		commandeClient.setLigneCommandeClient(commandeClientDto.getLigneCommandeClient().stream()
				.map(LigneCommandeClientDto::toEntity).collect(Collectors.toList()));

		return commandeClient;
	}

}
