package com.bp.cbe.configuration;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.repository.LoanRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PersonLoader implements CommandLineRunner {

    private LoanRepository loanRepository;

    @Override
    public void run(String... args) throws Exception {

    }

}
