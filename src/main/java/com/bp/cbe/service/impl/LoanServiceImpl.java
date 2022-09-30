package com.bp.cbe.service.impl;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.domain.enums.UserType;
import com.bp.cbe.exception.ReachedNumberOfLoanedDevicesForPersonException;
import com.bp.cbe.repository.LoanRepository;
import com.bp.cbe.repository.PersonRepository;
import com.bp.cbe.service.LoanService;
import com.bp.cbe.service.dto.LoanDto;
import com.bp.cbe.service.mapper.LoanMapper;
import com.bp.cbe.util.LoanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private PersonRepository personRepository;
    private LoanRepository loanRepository;
    private LoanMapper mapper;

    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        var currentLoans = loanRepository.findLoansByPersonId(loanDto.getPerson().getId());
        if (LoanUtils.reachedNumberOfCurrentLoans(currentLoans, loanDto.getPerson().getUserType())) {
            throw new ReachedNumberOfLoanedDevicesForPersonException();
        }

        Loan loan = mapper.dtoToLoan(loanDto);
        loanRepository.save(loan);
        return mapper.loanToDto(loan);
    }

    @Override
    public List<LoanDto> listOfLoans() {
        return mapper.listOfLoansToListOfDtos(loanRepository.findAll());
    }

}
