package io.ismaildrissi.ismaildrissiexam.dtos;

import io.ismaildrissi.ismaildrissiexam.enums.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CreditDTO {
    private Long id;
    private Date requestDate;
    private CreditStatus status;
    private Date acceptanceDate;
    private Double amount;
    private Integer duration;
    private Double interestRate;
    private ClientDTO client;
}