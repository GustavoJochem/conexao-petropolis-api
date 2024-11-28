package br.ucp.conexao_petropolis.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "enderecos")
public class Endereco {

	private static final String COLUMN_ID = "ID";
	private static final String COLUMN_LOGRADOURO = "LOGRADOURO";
	private static final String COLUMN_NUMERO = "NUMERO";
	private static final String COLUMN_BAIRRO = "BAIRRO";
	private static final String COLUMN_CIDADE = "CIDADE";
	private static final String COLUMN_ESTADO = "ESTADO";
	private static final String COLUMN_CEP = "CEP";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long id;

	@Column(name = COLUMN_LOGRADOURO)
	private String logradouro;

	@Column(name = COLUMN_NUMERO)
	private String numero;

	@Column(name = COLUMN_BAIRRO)
	private String bairro;

	@Column(name = COLUMN_CIDADE)
	private String cidade;

	@Column(name = COLUMN_ESTADO)
	private String estado;

	@Column(name = COLUMN_CEP)
	private String cep;
}