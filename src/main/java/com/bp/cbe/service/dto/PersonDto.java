package com.bp.cbe.service.dto;

import com.bp.cbe.domain.enums.PersonStatus;
import com.bp.cbe.domain.enums.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDto {

    @JsonProperty
    private long id;
    @JsonProperty
    private String userIdentifier;
    @JsonProperty
    private String names;
    @JsonProperty
    private String userType;
    @JsonProperty
    private PersonStatus status;

}
