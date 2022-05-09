package com.api.contacts.resources;

import com.api.contacts.dto.ContactDTO;
import com.api.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/contatos")
public class ContactResource {

    @Autowired
    private ContactService service;

    @GetMapping
    public ResponseEntity<List<ContactDTO>> findAll(){
        List<ContactDTO> contacts = service.findAll();
        return ResponseEntity.ok().body(contacts);
    }

}
