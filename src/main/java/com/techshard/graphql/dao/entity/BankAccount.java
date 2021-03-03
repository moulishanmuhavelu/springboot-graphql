package com.techshard.graphql.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    private transient  String formattedDate;

    // Getter and setter
    public String getFormattedDate() {
        return getDateOfBirth().toString();
    }
}
