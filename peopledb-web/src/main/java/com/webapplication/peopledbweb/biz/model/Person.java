package com.webapplication.peopledbweb.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message="First Name can not be empty")
    private String firstName;

    @NotEmpty(message="Last Name can not be empty")
    private String lastName;

    @Past(message="Date of Birth can not be in the past")
    @NotNull(message="Date must be specified")
    private LocalDate dob;

    @Email(message="Email must be valid")
    @NotEmpty(message="Email can not be empty")
    private String email;

    @DecimalMin(value="1000", message="Salary must be higher than 1000")
    @NotNull(message="Salary can not be empty")
    private BigDecimal salary;

    private String photoFilename;
}
