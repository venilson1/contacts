package com.api.contacts.repositories;

import com.api.contacts.entites.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}