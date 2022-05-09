package com.api.contacts.dto;

import com.api.contacts.entites.Contacts;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ContactsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long id;

    @NotEmpty(message = "Campo obrigatório")
    @Size(min = 3, message = "Nome minímo de 3 carácter")
    private final String name;
    @NotEmpty(message = "Campo obrigatório")
    private final String lastName;
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    private final String cpf;
    @Email(message = "favor entrar com email válido")
    private final String email;
    @NotEmpty(message = "Campo obrigatório")
    private final String telephone;

    public ContactsDTO(Long id, String name, String lastName, String cpf, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
    }

    public ContactsDTO(@NotNull Contacts entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.lastName = entity.getName();
        this.cpf = entity.getCpf();
        this.email = entity.getEmail();
        this.telephone = entity.getTelephone();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

}
