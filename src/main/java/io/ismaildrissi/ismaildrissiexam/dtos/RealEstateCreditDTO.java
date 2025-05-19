package io.ismaildrissi.ismaildrissiexam.dtos;

import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit.PropertyType;
import io.ismaildrissi.ismaildrissiexam.enums.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealEstateCreditDTO extends CreditDTO {
    private PropertyType propertyType;
}
