package com.api.contacts.services;

import com.api.contacts.dto.ContactDTO;
import com.api.contacts.entites.Contact;
import com.api.contacts.repositories.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
	private ContactRepository repository;

    @Transactional(readOnly = true)
    public List<ContactDTO> findAll(){
        List<Contact> contacts = repository.findAll();
        List<ContactDTO> contactsDTO = contacts.stream().map(el -> new ContactDTO(el)).collect(Collectors.toList());
        return contactsDTO;
    }
    
    @Transactional(readOnly = true)
    public ContactDTO insert(ContactDTO dto){
    	Contact entity = new Contact();
    	copyDtoToEntity(dto, entity);
    	entity = repository.save(entity);
        return new ContactDTO(entity);
    }

	private void copyDtoToEntity(ContactDTO dto, Contact entity) {
		entity.setName(dto.getName());
		entity.setLastName(dto.getLastName());
		entity.setCpf(dto.getCpf());
		entity.setEmail(dto.getEmail());
		entity.setTelephone(dto.getTelephone());
	}

}
