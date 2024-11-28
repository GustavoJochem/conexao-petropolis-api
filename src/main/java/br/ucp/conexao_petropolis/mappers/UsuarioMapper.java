package br.ucp.conexao_petropolis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.ucp.conexao_petropolis.controllers.data.UsuarioRequest;
import br.ucp.conexao_petropolis.models.Usuario;

@Mapper
public interface UsuarioMapper {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	Usuario requestParaModel(UsuarioRequest request);
}
