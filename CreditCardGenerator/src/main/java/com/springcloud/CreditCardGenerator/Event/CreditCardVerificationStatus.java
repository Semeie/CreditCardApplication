package com.springcloud.CreditCardGenerator.Event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreditCardVerificationStatus {
    private String firstName;
    private String lastName;
    private Integer annualIncome;
    private String address;
    private String refId;
    private VerificationStatus status;

    public enum VerificationStatus{
        APPROVED,
        REJECTED
    }
}