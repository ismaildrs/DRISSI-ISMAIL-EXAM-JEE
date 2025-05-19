package io.ismaildrissi.ismaildrissiexam.services.impl;

import io.ismaildrissi.ismaildrissiexam.entities.Repayment;
import io.ismaildrissi.ismaildrissiexam.repositories.RepaymentRepository;
import io.ismaildrissi.ismaildrissiexam.services.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RepaymentServiceImpl implements RepaymentService {

    private final RepaymentRepository repaymentRepository;

    @Autowired
    public RepaymentServiceImpl(RepaymentRepository repaymentRepository) {
        this.repaymentRepository = repaymentRepository;
    }

    @Override
    public List<Repayment> getAllRepayments() {
        return repaymentRepository.findAll();
    }

    @Override
    public Repayment getRepaymentById(Long id) {
        return repaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repayment not found with id: " + id));
    }

    @Override
    public Repayment saveRepayment(Repayment repayment) {
        return repaymentRepository.save(repayment);
    }

    @Override
    public void deleteRepayment(Long id) {
        repaymentRepository.deleteById(id);
    }

    @Override
    public List<Repayment> getRepaymentsByCreditId(Long creditId) {
        return repaymentRepository.findAll().stream()
                .filter(repayment -> repayment.getCredit() != null && repayment.getCredit().getId().equals(creditId))
                .collect(Collectors.toList());
    }
}