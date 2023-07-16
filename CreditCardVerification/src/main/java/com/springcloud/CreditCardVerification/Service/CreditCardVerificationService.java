package com.springcloud.CreditCardVerification.Service;

import com.springcloud.CreditCardVerification.Entity.CreditCardVerification;
import com.springcloud.CreditCardVerification.Repository.CreditCardVerificationRepo;
import com.springcloud.CreditCardVerification.event.CreditCardVerificationStatus;
import com.springcloud.CreditCardVerification.event.NewCreditCardEvent;
import com.springcloud.CreditCardVerification.event.VerifyCreditCardEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CreditCardVerificationService {

    private CreditCardVerificationRepo creditCardVerificationRepo;

    public VerifyCreditCardEvent verifyCreditCardApplication(NewCreditCardEvent newCreditCardEvent) {
        var creditCardApplications = newCreditCardEvent.getCreditCardApplications();
        var creditCardVerificationStatusList = creditCardApplications.stream().map(creditCardApplication -> {
            var creditCardVerificationStatus = CreditCardVerificationStatus.builder().build();
            BeanUtils.copyProperties(creditCardApplication, creditCardVerificationStatus);
            if(creditCardApplication.getAnnualIncome() > 4000){
                creditCardVerificationStatus.setStatus(CreditCardVerificationStatus.VerificationStatus.APPROVED);
            }else {
                creditCardVerificationStatus.setStatus(CreditCardVerificationStatus.VerificationStatus.REJECTED);
            }
            return creditCardVerificationStatus;
        }).collect(Collectors.toList());

        saveCreditCardVerificationStatus(creditCardVerificationStatusList);

        var verifyCreditCardEvent = VerifyCreditCardEvent.builder()
                .creditCardVerificationStatus(creditCardVerificationStatusList)
                .build();

        return verifyCreditCardEvent;
    }

    private void saveCreditCardVerificationStatus(List<CreditCardVerificationStatus> creditCardVerificationStatusList) {

        var creditCardVerifications = creditCardVerificationStatusList.stream().map(creditCardVerificationStatus -> {
           var creditCardVerification = new CreditCardVerification();
           BeanUtils.copyProperties(creditCardVerificationStatus, creditCardVerification);
           creditCardVerification.setStatus(creditCardVerificationStatus.getStatus().name());
           return creditCardVerification;
        }).collect(Collectors.toList());

        log.info("***** Saving credit card application status *****");
        creditCardVerificationRepo.saveAll(creditCardVerifications);
    }
}
