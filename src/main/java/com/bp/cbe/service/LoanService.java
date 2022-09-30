package com.bp.cbe.service;

import com.bp.cbe.service.dto.LoanDto;

import java.util.List;

public interface LoanService {

    LoanDto createLoan(LoanDto loan);

    List<LoanDto> listOfLoans();

}
