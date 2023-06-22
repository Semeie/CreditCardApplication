package com.springcloud.CreditApplication.Service;

import com.springcloud.CreditApplication.DTO.CreditCardRequest;
import com.springcloud.CreditApplication.Repository.CreditCardRepository;
import com.springcloud.CreditApplication.entity.CreditCard;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CreditCardService {
    private CreditCardRepository creditCardRepository;

    public Optional<String> saveApplication(CreditCardRequest creditCardRequest){
        try {
            var creditCard = new CreditCard();
            BeanUtils.copyProperties(creditCardRequest, creditCard);
            creditCard.setRefId(RandomString.make(10));
            var creditCardSaved = creditCardRepository.save(creditCard);
            return Optional.of(creditCardSaved.getRefId());
        }catch (Exception exception){
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
}
