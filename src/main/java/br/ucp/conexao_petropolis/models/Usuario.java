package br.ucp.conexao_petropolis.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

	private static final String COLUMN_ID = "ID";
	private static final String COLUMN_NOME = "NOME";
	private static final String COLUMN_CONTATO_ID = "CONTATO_ID";
	private static final String COLUMN_ENDERECO_ID = "ENDERECO_ID";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long id;

	@Column(name = COLUMN_NOME)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = COLUMN_CONTATO_ID)
	private Contato contato;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = COLUMN_ENDERECO_ID)
	private Endereco endereco;
}