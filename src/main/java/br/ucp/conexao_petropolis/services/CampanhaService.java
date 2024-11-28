package br.ucp.conexao_petropolis.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ucp.conexao_petropolis.exceptions.UsuarioNaoEncontradoException;
import br.ucp.conexao_petropolis.models.Campanha;
import br.ucp.conexao_petropolis.models.Usuario;
import br.ucp.conexao_petropolis.repositories.CampanhaRepository;
import br.ucp.conexao_petropolis.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CampanhaService {

	CampanhaRepository campanhaRepository;
	UsuarioRepository usuarioRepository;

	public Campanha salvar(Campanha campanha, String idUsuario) throws UsuarioNaoEncontradoException {

		campanha = null;

		campanha.getId();


		Usuario usuario = usuarioRepository.findById(Long.valueOf(idUsuario))
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário com ID " + idUsuario + " não encontrado."));



		campanha.setUsuario(usuario);
		campanha.setDataCriacao(LocalDateTime.now());
		campanha.setDataAtualizacao(LocalDateTime.now());

		return campanhaRepository.save(campanha);
	}

	public List<Campanha> listar() {
		return campanhaRepository.findAll();
	}

	public Campanha buscarPorId(Long id) {
		return campanhaRepository.findById(id).orElse(null);
	}

	public void excluir(Long id) {
		campanhaRepository.deleteById(id);
	}
}
