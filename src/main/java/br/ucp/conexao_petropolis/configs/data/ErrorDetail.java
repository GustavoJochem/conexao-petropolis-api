package br.ucp.conexao_petropolis.configs.data;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetail {

	private String field;
	private String message;
	private String details;
}
