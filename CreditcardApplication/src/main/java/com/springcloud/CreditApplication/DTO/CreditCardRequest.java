package com.springcloud.CreditApplication.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@Builder
@ApiModel
public class CreditCardRequest {

    @NonNull
    @ApiModelProperty(notes = "Customer First Name")
    private String firstName;
    @NonNull
    @ApiModelProperty(notes = "Customer Last Name")
    private String lastName;
    @NonNull
    @ApiModelProperty(notes = "Customer Annual Income")
    private Integer annualIncome;
    @NonNull
    @ApiModelProperty(notes = "Customer Address")
    private String address;
}
