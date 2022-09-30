package com.bp.cbe.configuration;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.domain.Person;
import com.bp.cbe.repository.LoanRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class LoansLoader implements CommandLineRunner {

    private LoanRepository loanRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Loan>> typeReference = new TypeReference<List<Loan>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/db.migration/loans.json");
        try {
            List<Loan> stores = mapper.readValue(inputStream,typeReference);
            loanRepository.saveAll(stores);
            System.out.println("Stores Saved!");
        } catch (IOException e){
            System.out.println("Unable to save stores: " + e.getMessage());
        }
    }

}
