package com.springcloud.CreditCardGenerator.Gateway;

import com.springcloud.CreditCardGenerator.Event.VerifyCreditCardEvent;
import com.springcloud.CreditCardGenerator.Service.CreditCardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@AllArgsConstructor
@Slf4j
@Configuration
public class CreditCardVerificationEventListener  {


    private CreditCardService creditCardService;
    public Consumer<VerifyCreditCardEvent> generateCreditCard(){
        return verifyCreditCardEvent -> {
            log.info("Received credit card application : {}",
                    verifyCreditCardEvent.getCreditCardVerificationStatus().size());
            creditCardService.generateCreditCardNumberAndCvv
                    (verifyCreditCardEvent.getCreditCardVerificationStatus());
        };
    }
}
