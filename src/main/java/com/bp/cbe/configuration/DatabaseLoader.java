package com.bp.cbe.configuration;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.repository.LoanRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DatabaseLoader implements CommandLineRunner {

    private LoanRepository

    @Override
    public void run(String... args) throws Exception {
        loadDataFromJson<Loan, LoanRepository>()
    }

    private <T,U> List<T> loadDataFromJson(U repository, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {};
//        InputStream inputStream = TypeReference.class.getResourceAsStream("/db.migration/loans.json");
        InputStream inputStream = TypeReference.class.getResourceAsStream(filename);
        try {
            List<Loan> stores = mapper.readValue(inputStream,typeReference);
            loanRepository.saveAll(stores);
        } catch (IOException e){
            System.out.println("Unable to save people: " + e.getMessage());
        }
    }
}
