package com.springcloud.CreditApplication.Controller;

import com.springcloud.CreditApplication.DTO.CreditCardRequest;
import com.springcloud.CreditApplication.Service.CreditCardService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/applyCreditCard/v1")
public class CreditCardController {
    private CreditCardService creditCardService;

    @PostMapping(path = "/applyCreditCard")
    public ResponseEntity<String> createNewCreditCardRequest(@RequestBody CreditCardRequest creditCardRequest){
        if(StringUtils.isEmpty(creditCardRequest.getFirstName())
         || StringUtils.isEmpty(creditCardRequest.getLastName())
         || StringUtils.isEmpty(creditCardRequest.getAddress())){
            return ResponseEntity.badRequest().build();
        }
        var applicationRefId = creditCardService.saveApplication(creditCardRequest);
        return applicationRefId.isEmpty()? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.status(HttpStatus.CREATED).body("Your application reference number is : " + applicationRefId.get());
    }
}
