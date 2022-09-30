package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.Person;
import com.bp.cbe.service.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto personToDto(Person person);

    Person dtoToPerson(PersonDto personDto);

    void updatePersonFromDto(PersonDto dto, @MappingTarget Person person);

}
