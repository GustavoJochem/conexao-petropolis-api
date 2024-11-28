package br.ucp.conexao_petropolis.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.ucp.conexao_petropolis.configs.data.ErrorDetail;
import br.ucp.conexao_petropolis.configs.data.ErrorResponse;
import br.ucp.conexao_petropolis.exceptions.UsuarioNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(
			MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		List<ErrorDetail> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(error -> ErrorDetail.builder()
						.field(error.getField())
						.message("Validation error")
						.details(error.getDefaultMessage())
						.build())
				.collect(Collectors.toList());

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
				.host(request.getServerName())
				.resource(request.getRequestURI())
				.title("Validation Errors")
				.errors(errors)
				.build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException ex,
			HttpServletRequest request) {

		ErrorDetail errorDetail = ErrorDetail.builder()
				.message("Erro de análise de JSON")
				.details(ex.getMessage())
				.build();

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
				.host(request.getServerName())
				.resource(request.getRequestURI())
				.title("JSON inválido")
				.errors(List.of(errorDetail))
				.build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleUsuarioNaoEncontradoException(
			UsuarioNaoEncontradoException ex,
			HttpServletRequest request) {

		ErrorDetail errorDetail = ErrorDetail.builder()
				.field("idUsuario")
				.message("Usuário não encontrado")
				.details(ex.getMessage())
				.build();

		ErrorResponse response = ErrorResponse.builder()
				.timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
				.host(request.getServerName())
				.resource(request.getRequestURI())
				.title("Usuário não encontrado")
				.errors(Collections.singletonList(errorDetail))
				.build();

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, HttpServletRequest request) {
		ErrorDetail errorDetail = ErrorDetail.builder()
				.message(ex.getLocalizedMessage())
				.build();

		ErrorResponse errorResponse = ErrorResponse.builder()
				.timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
				.host(request.getServerName())
				.resource(request.getRequestURI())
				.title("Erro Interno do Servidor")
				.errors(Collections.singletonList(errorDetail))
				.build();

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}