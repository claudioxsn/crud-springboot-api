package com.exercicios.crud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.exercicios.crud.model.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>{
	
}
