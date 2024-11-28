package br.ucp.conexao_petropolis.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucp.conexao_petropolis.controllers.data.UsuarioRequest;
import br.ucp.conexao_petropolis.mappers.UsuarioMapper;
import br.ucp.conexao_petropolis.models.Usuario;
import br.ucp.conexao_petropolis.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid UsuarioRequest request) {
		Usuario usuarioSalvo = usuarioService.salvar(UsuarioMapper.INSTANCE.requestParaModel(request));
		return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = usuarioService.listar();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		usuarioService.excluir(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
