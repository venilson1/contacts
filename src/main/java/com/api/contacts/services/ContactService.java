package com.api.contacts.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.contacts.dto.ContactDTO;
import com.api.contacts.entites.Contact;
import com.api.contacts.repositories.ContactRepository;
import com.api.contacts.services.exceptions.ResourceNotFoundException;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;

	@Transactional(readOnly = true)
	public List<ContactDTO> findAll() {
		List<Contact> contacts = repository.findAll();
		List<ContactDTO> contactsDTO = contacts.stream().map(el -> new ContactDTO(el)).collect(Collectors.toList());
		return contactsDTO;
	}

	@Transactional(readOnly = true)
	public ContactDTO findById(Long id) {
		Optional<Contact> obj = repository.findById(id);
		Contact entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found")); //500
		return new ContactDTO(entity);
	}

	@Transactional(readOnly = true)
	public ContactDTO insert(ContactDTO dto) {
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

	@Transactional
	public ContactDTO update(Long id, ContactDTO dto) {
		try {
			Contact entity = repository.getById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ContactDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}
	}
	
	  public void delete(Long id) {
		    try {
		      repository.deleteById(id);
		    } catch (EmptyResultDataAccessException e) {
		      throw new ResourceNotFoundException("Id Not Found " + id);
		    } 
		  }

}
