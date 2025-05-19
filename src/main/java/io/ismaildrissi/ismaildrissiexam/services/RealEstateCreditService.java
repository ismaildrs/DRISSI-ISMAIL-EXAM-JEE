package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.dtos.RealEstateCreditDTO;

import java.util.List;
import java.util.Optional;

public interface RealEstateCreditService {
    RealEstateCreditDTO save(RealEstateCreditDTO realEstateCreditDTO);
    List<RealEstateCreditDTO> findAll();
    Optional<RealEstateCreditDTO> findById(Long id);
    void delete(Long id);
}
