package br.ucp.conexao_petropolis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucp.conexao_petropolis.models.Campanha;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}
