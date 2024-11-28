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
@Table(name = "contatos")
public class Contato {

	private static final String COLUMN_ID = "ID";
	private static final String COLUMN_EMAIL = "EMAIL";
	private static final String COLUMN_TELEFONE = "TELEFONE";
	private static final String COLUMN_SITE = "SITE";
	private static final String COLUMN_FACEBOOK = "FACEBOOK";
	private static final String COLUMN_INSTAGRAM = "INSTAGRAM";
	private static final String COLUMN_TWITTER = "TWITTER";
	private static final String COLUMN_LINKEDIN = "LINKEDIN";
	private static final String COLUMN_YOUTUBE = "YOUTUBE";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = COLUMN_ID)
	private Long id;

	@Column(name = COLUMN_EMAIL)
	private String email;

	@Column(name = COLUMN_TELEFONE)
	private String telefone;

	@Column(name = COLUMN_SITE)
	private String site;

	@Column(name = COLUMN_FACEBOOK)
	private String facebook;

	@Column(name = COLUMN_INSTAGRAM)
	private String instagram;

	@Column(name = COLUMN_TWITTER)
	private String twitter;

	@Column(name = COLUMN_LINKEDIN)
	private String linkedin;

	@Column(name = COLUMN_YOUTUBE)
	private String youtube;
}