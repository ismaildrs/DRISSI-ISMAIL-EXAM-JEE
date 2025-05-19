package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.dtos.ProfessionalCreditDTO;

import java.util.List;
import java.util.Optional;

public interface ProfessionalCreditService {


    ProfessionalCreditDTO save(ProfessionalCreditDTO professionalCreditDTO);


    List<ProfessionalCreditDTO> findAll();

    Optional<ProfessionalCreditDTO> findById(Long id);

    void delete(Long id);
}