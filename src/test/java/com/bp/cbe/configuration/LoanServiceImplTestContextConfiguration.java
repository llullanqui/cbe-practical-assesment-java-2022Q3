package com.bp.cbe.configuration;

import com.bp.cbe.service.LoanService;
import com.bp.cbe.service.impl.LoanServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class LoanServiceImplTestContextConfiguration {
    @Bean
    public LoanService employeeService() {
        return new LoanServiceImpl();
    }
}

