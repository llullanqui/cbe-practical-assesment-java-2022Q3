package com.bp.cbe.service.impl;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.repository.LoanRepository;
import com.bp.cbe.service.LoanService;
import com.bp.cbe.service.dto.LoanDto;
import com.bp.cbe.service.mapper.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;
    private LoanMapper mapper;

    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        Loan loan = mapper.dtoToLoan(loanDto);
        loanRepository.save(loan);
        return mapper.loanToDto(loan);
    }

    @Override
    public List<LoanDto> listOfLoans() {
        return mapper.listOfLoansToListOfDtos(loanRepository.findAll());
    }

}
