package br.ucp.conexao_petropolis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.ucp.conexao_petropolis.controllers.data.CampanhaRequest;
import br.ucp.conexao_petropolis.models.Campanha;

@Mapper
public interface CampanhaMapper {

	CampanhaMapper INSTANCE = Mappers.getMapper(CampanhaMapper.class);

	Campanha requestParaModel(CampanhaRequest request);
}
