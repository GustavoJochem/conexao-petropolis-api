-- Criação do tipo ENUM para tipos de campanha/evento
CREATE TYPE TIPO_CAMPANHA AS ENUM (
    'ANIMAIS',
    'IDOSOS',
    'CRIANÇAS',
    'MEIO_AMBIENTE',
    'SAUDE',
    'EDUCACAO',
    'OUTROS'
);

-- Criação do tipo ENUM para status da campanha/evento
CREATE TYPE STATUS_CAMPANHA AS ENUM (
    'ATIVO',
    'ENCERRADO',
    'PENDENTE'
);

-- Criação da tabela de endereços
CREATE TABLE enderecos (
                           id SERIAL PRIMARY KEY,
                           logradouro VARCHAR(255) NOT NULL,
                           numero VARCHAR(10),
                           bairro VARCHAR(100),
                           cidade VARCHAR(100) NOT NULL,
                           estado VARCHAR(50) NOT NULL,
                           cep VARCHAR(10),
                           geolocalizacao GEOGRAPHY(POINT, 4326)
);

-- Criação da tabela de contatos
CREATE TABLE contatos (
                          id SERIAL PRIMARY KEY,
                          email VARCHAR(255),
                          telefone VARCHAR(50),
                          site VARCHAR(255),
                          facebook VARCHAR(255),
                          instagram VARCHAR(255),
                          twitter VARCHAR(255),
                          linkedin VARCHAR(255),
                          youtube VARCHAR(255),
                          outras_redes TEXT[]
);

-- Criação da tabela de usuários
CREATE TABLE usuarios (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          contato_id INT REFERENCES contatos(id) ON DELETE CASCADE
);

-- Criação da tabela de campanhas e eventos
CREATE TABLE campanhas_eventos (
                                   id SERIAL PRIMARY KEY,
                                   nome VARCHAR(255) NOT NULL,
                                   descricao TEXT,
                                   tipo TIPO_CAMPANHA,
                                   usuario_id INT REFERENCES usuarios(id) ON DELETE SET NULL,
                                   contato_id INT REFERENCES contatos(id) ON DELETE CASCADE,
                                   aceita_doacoes BOOLEAN DEFAULT TRUE,
                                   aceita_voluntarios BOOLEAN DEFAULT TRUE,
                                   endereco_id INT REFERENCES enderecos(id) ON DELETE CASCADE,
                                   url_imagem VARCHAR(255),
                                   status STATUS_CAMPANHA,
                                   data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);