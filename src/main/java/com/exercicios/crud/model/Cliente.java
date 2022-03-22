package com.exercicios.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O campo nome não pode ser vazio")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "O campo nome deve iniciar com letra maiúscula")
	private String nome;

	@CPF(message = "CPF inválido")
	@NotBlank(message = "O campo CPF não pode ser vazio")
	@Column(unique = true, nullable =  false)
	private String cpf;

	public Cliente() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
