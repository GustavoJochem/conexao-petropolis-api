package br.ucp.conexao_petropolis.models;

import java.time.LocalDateTime;

import br.ucp.conexao_petropolis.models.enums.StatusCampanha;
import br.ucp.conexao_petropolis.models.enums.TipoCampanha;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "campanhas")
public class Campanha {

	private static final String COLUMN_ID = "ID";
	private static final String COLUMN_NOME = "NOME";
	private static final String COLUMN_DESCRICAO = "DESCRICAO";
	private static final String COLUMN_TIPO = "TIPO";
	private static final String COLUMN_USUARIO_ID = "USUARIO_ID";
	private static final String COLUMN_CONTATO_ID = "CONTATO_ID";
	private static final String COLUMN_ACEITA_DOACOES = "ACEITA_DOACOES";
	private static final String COLUMN_ACEITA_VOLUNTARIOS = "ACEITA_VOLUNTARIOS";
	private static final String COLUMN_ENDERECO_ID = "ENDERECO_ID";
	private static final String COLUMN_URL_IMAGEM = "URL_IMAGEM";
	private static final String COLUMN_STATUS = "STATUS";
	private static final String COLUMN_DATA_CRIACAO = "DATA_CRIACAO";
	private static final String COLUMN_DATA_ATUALIZACAO = "DATA_ATUALIZACAO";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long id;

	@Column(name = COLUMN_NOME)
	private String nome;

	@Column(name = COLUMN_DESCRICAO)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUMN_TIPO)
	private TipoCampanha tipo;

	@ManyToOne
	@JoinColumn(name = COLUMN_USUARIO_ID, referencedColumnName = COLUMN_ID)
	private Usuario usuario;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = COLUMN_CONTATO_ID)
	private Contato contato;

	@Column(name = COLUMN_ACEITA_DOACOES)
	private Boolean aceitaDoacoes;

	@Column(name = COLUMN_ACEITA_VOLUNTARIOS)
	private Boolean aceitaVoluntarios;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = COLUMN_ENDERECO_ID)
	private Endereco endereco;

	@Column(name = COLUMN_URL_IMAGEM)
	private String urlImagem;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUMN_STATUS)
	private StatusCampanha status;

	@Column(name = COLUMN_DATA_CRIACAO)
	private LocalDateTime dataCriacao;

	@Column(name = COLUMN_DATA_ATUALIZACAO)
	private LocalDateTime dataAtualizacao;
}