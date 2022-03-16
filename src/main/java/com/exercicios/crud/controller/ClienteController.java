package com.exercicios.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercicios.crud.model.Cliente;
import com.exercicios.crud.service.ClienteService;

@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public @ResponseBody Cliente store(@RequestBody Cliente cliente) {
		return clienteService.store(cliente);
	}

	@GetMapping
	public Iterable<Cliente> list(@RequestParam int page) {
		return clienteService.list(page);
	}
	
	
}
