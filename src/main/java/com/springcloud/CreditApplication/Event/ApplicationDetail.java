package com.springcloud.CreditApplication.Event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApplicationDetail {
    private String firstName;
    private String lastName;
    private Integer annualIncome;
    private String address;
    private boolean publishStatus;
    private String refId;
}
