package io.ismaildrissi.ismaildrissiexam.dtos;

import io.ismaildrissi.ismaildrissiexam.enums.RepaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepaymentDTO {
    private Long id;
    private Date date;
    private Double amount;
    private RepaymentType type;
    private Long creditId;
}