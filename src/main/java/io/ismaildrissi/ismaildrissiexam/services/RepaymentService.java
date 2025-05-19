package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.dtos.RepaymentDTO;

import java.util.List;
import java.util.Optional;

public interface RepaymentService {
    RepaymentDTO save(RepaymentDTO repaymentDTO);
    List<RepaymentDTO> findAll();
    Optional<RepaymentDTO> findById(Long id);
    void delete(Long id);
    List<RepaymentDTO> findByCreditId(Long creditId);
}
