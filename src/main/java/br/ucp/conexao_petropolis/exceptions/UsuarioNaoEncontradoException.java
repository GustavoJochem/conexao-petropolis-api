package br.ucp.conexao_petropolis.exceptions;

import org.apache.coyote.BadRequestException;

public class UsuarioNaoEncontradoException extends BadRequestException {
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
