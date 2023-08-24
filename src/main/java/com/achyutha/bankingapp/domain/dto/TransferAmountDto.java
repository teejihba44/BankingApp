package com.achyutha.bankingapp.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * A Transfer amount DTO.
 */
@Getter
@Setter
@Accessors(chain = true)
public class TransferAmountDto {

    @NotNull(message = "transfer.amount.accountid.null")
    private String targetAccountId;

    @NotNull(message = "transfer.amount.amount.null")
    private Long amount;


}
