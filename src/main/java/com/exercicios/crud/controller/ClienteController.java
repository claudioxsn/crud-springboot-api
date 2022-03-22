package com.exercicios.crud.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exercicios.crud.model.Cliente;
import com.exercicios.crud.service.ClienteService;

@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public @ResponseBody Cliente store(@RequestBody @Validated Cliente cliente) {
		return clienteService.store(cliente);
	}

	@GetMapping
	public Iterable<Cliente> list(@RequestParam int page) {
		return clienteService.list(page);
	}
	
	@GetMapping(path = "/search/{nome}" )
	public Iterable<Cliente> findByNome(@PathVariable String nome){ 
		return clienteService.findByNome(nome);
	}

	@PutMapping
	public Cliente update(@RequestBody @Validated Cliente cliente) {
		return clienteService.update(cliente);
	}

	@DeleteMapping
	public void delete(int id) {
		clienteService.delete(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handlerValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
