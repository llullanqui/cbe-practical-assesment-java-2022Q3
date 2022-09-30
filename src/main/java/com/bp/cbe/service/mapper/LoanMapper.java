package com.bp.cbe.service.mapper;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.service.dto.LoanDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    LoanDto loanToDto(Loan loan);

    Loan dtoToLoan(LoanDto loanDto);

    List<LoanDto> listOfLoansToListOfDtos(List<Loan> loans);

}
