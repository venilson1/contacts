package com.api.contacts.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.contacts.dto.ContactDTO;
import com.api.contacts.services.ContactService;

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
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ContactDTO> findById(@PathVariable Long id) {
      ContactDTO dto = service.findById(id);
      return ResponseEntity.ok().body(dto);
    }
    
    @PostMapping
    public ResponseEntity<ContactDTO> insert(@Valid @RequestBody ContactDTO dto){
    	dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<ContactDTO> update(@PathVariable Long id, @Valid @RequestBody ContactDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

}
