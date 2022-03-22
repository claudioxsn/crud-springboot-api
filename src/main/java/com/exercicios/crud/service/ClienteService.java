package com.exercicios.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.exercicios.crud.model.Cliente;
import com.exercicios.crud.repository.ClienteRepository;

@Component
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente store(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Iterable<Cliente> list(int page) {
		Pageable paginate = PageRequest.of(page, 3);
		return clienteRepository.findAll(paginate);
	}

	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void delete(int id) {
		
		clienteRepository.deleteById(id);
	}
	
	public Iterable<Cliente> findByNome(String nome){ 
		return clienteRepository.findByNomeContainingIgnoreCase(nome); 
	}

}
