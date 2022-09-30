package com.bp.cbe.controller;

import com.bp.cbe.service.PersonService;
import com.bp.cbe.service.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PersonDto> getClient(@PathVariable long id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        return new ResponseEntity<>(personService.createPerson(personDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable long id, @RequestBody PersonDto personDto) {
        return new ResponseEntity<>(personService.updatePerson(id, personDto), HttpStatus.ACCEPTED);
    }
}
