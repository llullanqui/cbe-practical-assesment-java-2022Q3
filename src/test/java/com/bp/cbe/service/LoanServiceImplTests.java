package com.bp.cbe.service;

import com.bp.cbe.repository.LoanRepository;
import com.bp.cbe.service.impl.LoanServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class LoanServiceImplTests {

    @Autowired
    private LoanServiceImpl loanService;

    @MockBean
    private LoanRepository loanRepository;

}
