package com.bp.cbe.service.dto;

import com.bp.cbe.domain.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoanDto {

    @JsonProperty
    private long id;
    @JsonProperty
    private String deviceSerial;
    @JsonProperty
    private LocalDate loanedDate;
    @JsonProperty
    private LocalDate returnDate;
    @JsonProperty
    private PersonDto person;

}
