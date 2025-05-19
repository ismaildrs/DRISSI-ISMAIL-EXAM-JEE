package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.dtos.PersonalCreditDTO;

import java.util.List;
import java.util.Optional;

public interface PersonalCreditService {


    PersonalCreditDTO save(PersonalCreditDTO personalCreditDTO);


    List<PersonalCreditDTO> findAll();


    Optional<PersonalCreditDTO> findById(Long id);


    void delete(Long id);
}