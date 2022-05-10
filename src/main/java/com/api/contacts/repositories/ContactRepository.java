package com.api.contacts.repositories;

import java.util.List;

import com.api.contacts.entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
}