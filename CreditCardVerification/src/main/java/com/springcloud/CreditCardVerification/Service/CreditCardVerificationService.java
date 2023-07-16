package com.springcloud.CreditCardVerification.Service;

import com.springcloud.CreditCardVerification.Repository.CreditCardVerificationRepo;
import com.springcloud.CreditCardVerification.event.NewCreditCardEvent;
import com.springcloud.CreditCardVerification.event.VerifyCreditCardEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CreditCardVerificationService {

    private CreditCardVerificationRepo creditCardVerificationRepo;

    public VerifyCreditCardEvent verifyCreditCardApplication(NewCreditCardEvent newCreditCardEvent) {
        return null;
    }
}
