package com.api.contacts.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.contacts.entites.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	@Query("SELECT DISTINCT obj FROM Contact obj WHERE "
			+ "(:name = '' OR LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%') ) )")
	List<Contact> find(String name);
	
}