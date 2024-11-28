package br.ucp.conexao_petropolis.controllers.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRequest {

	@NotBlank(message = "O nome é obrigatório.")
	@Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
	private String nome;

	@NotNull(message = "O contato é obrigatório.")
	private ContatoRequest contato;

	@NotNull(message = "O endereço é obrigatório.")
	private EnderecoRequest endereco;

}