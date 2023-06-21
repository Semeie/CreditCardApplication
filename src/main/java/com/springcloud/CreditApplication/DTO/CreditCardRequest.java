package com.springcloud.CreditApplication.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CreditCardRequest {
    private String firstName;
    private String lastName;
    private Integer annualIncome;
    private String address;
}
