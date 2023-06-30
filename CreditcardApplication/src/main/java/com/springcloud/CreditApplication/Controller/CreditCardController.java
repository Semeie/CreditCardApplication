package com.springcloud.CreditApplication.Controller;

import com.springcloud.CreditApplication.DTO.CreditCardRequest;
import com.springcloud.CreditApplication.Service.CreditCardService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name= "Credit Card Application")
@Api(tags = "Credit Card Application")
public class CreditCardController {
    private CreditCardService creditCardService;

    @ApiOperation(value = "Create a credit card application for a new customer")
    @ApiResponses(value = {@ApiResponse(code=500, message = "Internal Server Error"),
                  @ApiResponse(code=200, message= "OK", response = String.class)})
    @PostMapping(path = "/applyCreditCard")
    public ResponseEntity<String> createNewCreditCardRequest(@RequestBody CreditCardRequest creditCardRequest){
        if(StringUtils.isEmpty(creditCardRequest.getFirstName())
         || StringUtils.isEmpty(creditCardRequest.getLastName())
         || StringUtils.isEmpty(creditCardRequest.getAddress())){
            return ResponseEntity.badRequest().build();
        }
        var applicationRefId = creditCardService.saveApplication(creditCardRequest);
        return applicationRefId.isEmpty()  ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.status(HttpStatus.CREATED).body("Your application reference number is : " + applicationRefId.get());
    }
}
