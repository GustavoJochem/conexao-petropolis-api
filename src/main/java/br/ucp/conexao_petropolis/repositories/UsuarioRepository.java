package br.ucp.conexao_petropolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucp.conexao_petropolis.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
