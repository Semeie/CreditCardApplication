package com.springcloud.CreditCardVerification.event;

import java.util.List;

public class VerifyCreditCardEvent {

    private VerifyCreditCardEvent.eventType event = VerifyCreditCardEvent.eventType.Approve_Credit_Card;
    private List<CreditCardVerificationStatus> creditCardVerificationStatuses;

    enum eventType{
        Approve_Credit_Card
    }
}
