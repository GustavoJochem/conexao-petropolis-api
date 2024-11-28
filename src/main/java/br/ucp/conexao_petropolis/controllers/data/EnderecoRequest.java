package br.ucp.conexao_petropolis.controllers.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoRequest {

	@NotBlank(message = "O logradouro é obrigatório.")
	@Size(max = 255, message = "O logradouro deve ter no máximo 255 caracteres.")
	private String logradouro;

	@NotBlank(message = "O número é obrigatório.")
	@Size(max = 10, message = "O número deve ter no máximo 10 caracteres.")
	private String numero;

	@NotBlank(message = "O bairro é obrigatório.")
	@Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres.")
	private String bairro;

	@NotBlank(message = "A cidade é obrigatória.")
	@Size(max = 100, message = "A cidade deve ter no máximo 100 caracteres.")
	private String cidade;

	@NotBlank(message = "O estado é obrigatório.")
	@Size(min = 2, max = 2, message = "O estado deve ter exatamente 2 caracteres.")
	private String estado;

	@NotBlank(message = "O CEP é obrigatório.")
	@Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "O CEP deve estar no formato 00000-000 ou 00000000.")
	private String cep;

}
