package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.entities.Repayment;

import java.util.List;

public interface RepaymentService {
    List<Repayment> getAllRepayments();
    Repayment getRepaymentById(Long id);
    Repayment saveRepayment(Repayment repayment);
    void deleteRepayment(Long id);
    
    // Credit-related operations
    List<Repayment> getRepaymentsByCreditId(Long creditId);
}