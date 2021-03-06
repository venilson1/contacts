package com.api.contacts.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.jetbrains.annotations.NotNull;

import com.api.contacts.entites.Contact;

public class ContactDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Campo obrigatório")
	@Size(min = 3, message = "Nome minímo de 3 carácter")
	private String name;
	@NotEmpty(message = "Campo obrigatório")
	private String lastName;
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "CPF deve possuir o padrão 000.000.000-00")
	private String cpf;

	@Email(message = "email inválido")
	private String email;

	private String phone;

	public ContactDTO(Long id, String name, String lastName, String cpf, String email, String phone) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
	}

	public ContactDTO(@NotNull Contact entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.lastName = entity.getLastName();
		this.cpf = entity.getCpf();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
