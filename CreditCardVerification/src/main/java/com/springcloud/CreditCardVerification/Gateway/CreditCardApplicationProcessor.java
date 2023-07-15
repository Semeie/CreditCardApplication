package com.springcloud.CreditCardVerification.Gateway;

import com.springcloud.CreditCardVerification.Service.CreditCardVerificationService;
import com.springcloud.CreditCardVerification.event.NewCreditCardEvent;
import com.springcloud.CreditCardVerification.event.VerifyCreditCardEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


@Configuration
@AllArgsConstructor
@Slf4j
public class CreditCardApplicationProcessor {

    private CreditCardVerificationService creditCardVerificationService;

    public Function<NewCreditCardEvent, VerifyCreditCardEvent> verifyCreditCardApplication(){
        return newCreditCardEvent -> {
            var verifyCreditCardEvent = creditCardVerificationService
                    .verifyCreditCardApplication(newCreditCardEvent);
            log.info("**** Publishing credit card application verification status : {} ****",verifyCreditCardEvent
                    .getCreditCardVerificationStatus().size());
            return (verifyCreditCardEvent.getCreditCardVerificationStatus().isEmpty()) ? null : verifyCreditCardEvent;
        };
    }
}
