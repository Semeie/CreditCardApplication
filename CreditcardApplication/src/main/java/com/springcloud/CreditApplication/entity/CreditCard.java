package com.springcloud.CreditApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ANNUAL_INCOME")
    private Integer annualIncome;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "IS_PUBLISHED")
    private boolean publishStatus;
    @Column(name = "REFERENCE_ID")
    private String refId;

}
