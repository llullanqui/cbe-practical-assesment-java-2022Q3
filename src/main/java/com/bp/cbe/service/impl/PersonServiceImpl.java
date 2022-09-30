package com.bp.cbe.service.impl;

import com.bp.cbe.domain.Person;
import com.bp.cbe.domain.enums.UserType;
import com.bp.cbe.exception.UserTypeDoesNotExistException;
import com.bp.cbe.repository.PersonRepository;
import com.bp.cbe.service.PersonService;
import com.bp.cbe.service.dto.PersonDto;
import com.bp.cbe.service.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private PersonMapper mapper;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        try {
            UserType.valueOf(personDto.getUserType());
        } catch (IllegalArgumentException exception) {
            throw new UserTypeDoesNotExistException();
        }
        Person person = mapper.dtoToPerson(personDto);
        personRepository.save(person);
        return mapper.personToDto(person);
    }

    @Override
    public PersonDto updatePerson(long id, PersonDto personDto) {
        Person person = personRepository.getReferenceById(id);
        mapper.updatePersonFromDto(personDto, person);
        personRepository.save(person);
        return mapper.personToDto(person);
    }

    @Override
    public PersonDto getPerson(long id) {
        return mapper.personToDto(personRepository.getReferenceById(id));
    }
}
