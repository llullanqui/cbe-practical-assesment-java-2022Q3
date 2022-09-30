package com.bp.cbe.repository;

import com.bp.cbe.domain.Loan;
import com.bp.cbe.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

//    List<Loan> findLoansByReturnDateLoanedDateAndResponsible(LocalDateTime returnDate, LocalDateTime loanedDate, Person person);

    @Query("SELECT loan FROM loans loan where loan.person.id = :id")
    List<Loan> findLoansByPersonId(@Param("id") long id);

}
