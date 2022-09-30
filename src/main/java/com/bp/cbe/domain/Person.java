package com.bp.cbe.domain;

import com.bp.cbe.domain.enums.PersonStatus;
import com.bp.cbe.domain.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(updatable = false, nullable = false, unique = true)
    private String userIdentifier;

    @Column(name = "names", nullable = false, updatable = false)
    private String names;

    @Column(name = "user_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Column(name = "status", nullable = false, columnDefinition = "varchar(255) default 'CREADO'")
    @Enumerated(value = EnumType.STRING)
    private PersonStatus status;

}
