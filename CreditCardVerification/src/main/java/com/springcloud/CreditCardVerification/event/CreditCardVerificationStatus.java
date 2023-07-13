package com.springcloud.CreditCardVerification.event;

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
