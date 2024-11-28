package br.ucp.conexao_petropolis.configs.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private String timestamp;
	private String host;
	private String resource;
	private String title;
	private List<ErrorDetail> errors;
}
