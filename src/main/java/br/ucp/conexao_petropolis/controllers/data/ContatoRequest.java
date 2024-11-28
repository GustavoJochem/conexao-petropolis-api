package br.ucp.conexao_petropolis.controllers.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ContatoRequest {

	@Email(message = "O email deve ser válido.")
	@NotBlank(message = "O email é obrigatório.")
	private String email;

	@NotBlank(message = "O telefone é obrigatório.")
	@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "O telefone deve ser um número válido, contendo entre 10 e 15 dígitos.")
	private String telefone;

	@Pattern(regexp = "^(http|https)://.*$", message = "O site deve ser uma URL válida e começar com http:// ou https://.")
	private String site;

	@Pattern(regexp = "^(http|https)://.*$", message = "O Facebook deve ser uma URL válida e começar com http:// ou https://.")
	private String facebook;

	@Pattern(regexp = "^(http|https)://.*$", message = "O Instagram deve ser uma URL válida e começar com http:// ou https://.")
	private String instagram;

	@Pattern(regexp = "^(http|https)://.*$", message = "O Twitter deve ser uma URL válida e começar com http:// ou https://.")
	private String twitter;

	@Pattern(regexp = "^(http|https)://.*$", message = "O LinkedIn deve ser uma URL válida e começar com http:// ou https://.")
	private String linkedin;

	@Pattern(regexp = "^(http|https)://.*$", message = "O YouTube deve ser uma URL válida e começar com http:// ou https://.")
	private String youtube;

}