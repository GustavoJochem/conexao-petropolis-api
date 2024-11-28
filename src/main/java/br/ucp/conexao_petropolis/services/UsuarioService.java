package br.ucp.conexao_petropolis.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ucp.conexao_petropolis.models.Usuario;
import br.ucp.conexao_petropolis.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	UsuarioRepository usuarioRepository;

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}
}
