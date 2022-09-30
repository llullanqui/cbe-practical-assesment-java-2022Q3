package com.bp.cbe.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "loans")
@Table
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "device_serial", nullable = false)
    private String deviceSerial;

    @CreationTimestamp
    @Column(name = "loaned_date", columnDefinition = "DATE", nullable = false)
    private LocalDate loanedDate;

    @CreationTimestamp
    @Column(name = "return_date", columnDefinition = "DATE", nullable = false)
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "FK_PERSON", nullable = false, updatable = false)
    private Person person;
}
