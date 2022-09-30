package com.bp.cbe.service;

import com.bp.cbe.service.dto.PersonDto;

public interface PersonService {

    PersonDto createPerson(PersonDto personDto);

    PersonDto updatePerson(long id, PersonDto personDto);

    PersonDto getPerson(long id);

}
