package com.springcloud.CreditCardGenerator.Service;

import com.springcloud.CreditCardGenerator.Entity.CreditCard;
import com.springcloud.CreditCardGenerator.Event.CreditCardVerificationStatus;
import com.springcloud.CreditCardGenerator.Repository.CreditCardRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Slf4j
public class CreditCardService {

    private CreditCardRepo creditCardRepo;

    public void generateCreditCardNumberAndCvv
            (List<CreditCardVerificationStatus> creditCardVerificationStatus) {
        var creditCards = creditCardVerificationStatus.stream().map(ccVerificationStatus-> {
            var creditCard = new CreditCard();
            BeanUtils.copyProperties(ccVerificationStatus, creditCard);
            if(ccVerificationStatus.getStatus().equals
                    (CreditCardVerificationStatus.VerificationStatus.APPROVED)){
                log.info("**** Credit Card number will be generated as application is approved : {}",
                        ccVerificationStatus.getRefId());
                var creditCardNumber = generateRandomInt(100000000000L, 999999999999L);
                creditCard.setCreditCardNumber(creditCardNumber);
                var cvv = generateRandomInt(100L, 999L);
                creditCard.setCvv(cvv);
            }else{
                log.info("**** Credit Card number will not be generated as application is rejected : {}",
                        ccVerificationStatus.getRefId());
                creditCard.setCreditCardNumber(0L);
                creditCard.setCvv(0L);
            }
            creditCard.setStatus(ccVerificationStatus.getStatus().name());
            return creditCard;
        }).collect(Collectors.toList());

        log.info("**** Saving Credit Cards ****");
        creditCardRepo.saveAll(creditCards);
        log.info("**** Saved Credit Cards ****");
    }

    private Long generateRandomInt(Long min, Long max) {
        var randomDataGenerator = new RandomDataGenerator();
        return randomDataGenerator.nextLong(min,max);
    }

    public String getApplicationStatus(String applicationRefId) {
        log.info("*** Searching application status for reference id : {}" , applicationRefId);
        var creditCard = creditCardRepo.findByRefId(applicationRefId);
        return creditCard.getStatus();
    }
}
