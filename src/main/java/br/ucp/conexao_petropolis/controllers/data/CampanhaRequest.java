package br.ucp.conexao_petropolis.controllers.data;

import br.ucp.conexao_petropolis.models.enums.StatusCampanha;
import br.ucp.conexao_petropolis.models.enums.TipoCampanha;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CampanhaRequest {

	@NotBlank(message = "O nome da campanha é obrigatório.")
	@Size(max = 100, message = "O nome da campanha deve ter no máximo 100 caracteres.")
	private String nome;

	@NotBlank(message = "A descrição da campanha é obrigatória.")
	@Size(max = 500, message = "A descrição da campanha deve ter no máximo 500 caracteres.")
	private String descricao;

	@NotNull(message = "O tipo da campanha é obrigatório.")
	private TipoCampanha tipo;

	@NotNull(message = "O campo usuarioId é obrigatório")
	private String idUsuario;

	@Valid
	@NotNull
	private ContatoRequest contato;

	@Valid
	@NotNull
	private EnderecoRequest endereco;

	@NotNull(message = "O status da campanha é obrigatório.")
	private StatusCampanha status;

	@NotNull(message = "A informação sobre aceitar doações é obrigatória.")
	private Boolean aceitaDoacoes;

	@NotNull(message = "A informação sobre aceitar voluntários é obrigatória.")
	private Boolean aceitaVoluntarios;

	@Pattern(regexp = "^(http|https)://.*$", message = "A URL da imagem deve ser uma URL válida e começar com http:// ou https://.")
	private String urlImagem;
}
