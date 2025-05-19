package io.ismaildrissi.ismaildrissiexam.dtos;

import io.ismaildrissi.ismaildrissiexam.enums.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalCreditDTO extends CreditDTO {
    private String reason;
}
