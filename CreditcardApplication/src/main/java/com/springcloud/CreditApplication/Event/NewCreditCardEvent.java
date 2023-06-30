package com.springcloud.CreditApplication.Event;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class NewCreditCardEvent {
    private eventType event = eventType.New_Credit_Card;
    private List<ApplicationDetail> creditCardApplications;

    enum eventType{
        New_Credit_Card
    }
}
