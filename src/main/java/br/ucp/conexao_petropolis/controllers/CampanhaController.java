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

import br.ucp.conexao_petropolis.controllers.data.CampanhaRequest;
import br.ucp.conexao_petropolis.exceptions.UsuarioNaoEncontradoException;
import br.ucp.conexao_petropolis.mappers.CampanhaMapper;
import br.ucp.conexao_petropolis.models.Campanha;
import br.ucp.conexao_petropolis.services.CampanhaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/campanhas")
public class CampanhaController {

	private final CampanhaService campanhaService;

	@PostMapping
	public ResponseEntity<Campanha> cadastrar(@RequestBody @Valid CampanhaRequest request) throws UsuarioNaoEncontradoException {
		Campanha campanhaSalvo = campanhaService.salvar(CampanhaMapper.INSTANCE.requestParaModel(request), request.getIdUsuario());
		return new ResponseEntity<>(campanhaSalvo, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Campanha> buscarPorId(@PathVariable Long id) {
		Campanha campanha = campanhaService.buscarPorId(id);
		return new ResponseEntity<>(campanha, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Campanha>> listar() {
		List<Campanha> campanhas = campanhaService.listar();
		return new ResponseEntity<>(campanhas, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		campanhaService.excluir(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
