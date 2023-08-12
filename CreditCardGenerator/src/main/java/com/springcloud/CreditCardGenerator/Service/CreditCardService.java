package com.springcloud.CreditCardGenerator.Service;

import com.springcloud.CreditCardGenerator.Event.CreditCardVerificationStatus;
import com.springcloud.CreditCardGenerator.Repository.CreditCardRepo;

import java.util.List;

public class CreditCardService {

    private CreditCardRepo creditCardRepo;

    public void generateCreditCardNumberAndCvv
            (List<CreditCardVerificationStatus> creditCardVerificationStatus) {
    }
}
