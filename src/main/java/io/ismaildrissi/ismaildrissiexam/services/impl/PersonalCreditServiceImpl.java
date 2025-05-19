package io.ismaildrissi.ismaildrissiexam.services.impl;

import io.ismaildrissi.ismaildrissiexam.dtos.PersonalCreditDTO;
import io.ismaildrissi.ismaildrissiexam.entities.PersonalCredit;
import io.ismaildrissi.ismaildrissiexam.mappers.PersonalCreditMapper;
import io.ismaildrissi.ismaildrissiexam.repositories.CreditRepository;
import io.ismaildrissi.ismaildrissiexam.services.PersonalCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonalCreditServiceImpl implements PersonalCreditService {

    private final CreditRepository creditRepository;
    private final PersonalCreditMapper personalCreditMapper;

    @Autowired
    public PersonalCreditServiceImpl(CreditRepository creditRepository, PersonalCreditMapper personalCreditMapper) {
        this.creditRepository = creditRepository;
        this.personalCreditMapper = personalCreditMapper;
    }

    @Override
    public PersonalCreditDTO save(PersonalCreditDTO personalCreditDTO) {
        PersonalCredit personalCredit = personalCreditMapper.toEntity(personalCreditDTO);
        personalCredit = creditRepository.save(personalCredit);
        return personalCreditMapper.toDto(personalCredit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalCreditDTO> findAll() {
        return creditRepository.findAll().stream()
                .filter(credit -> credit instanceof PersonalCredit)
                .map(credit -> personalCreditMapper.toDto((PersonalCredit) credit))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonalCreditDTO> findById(Long id) {
        return creditRepository.findById(id)
                .filter(credit -> credit instanceof PersonalCredit)
                .map(credit -> personalCreditMapper.toDto((PersonalCredit) credit));
    }

    @Override
    public void delete(Long id) {
        creditRepository.findById(id)
                .filter(credit -> credit instanceof PersonalCredit)
                .ifPresent(creditRepository::delete);
    }
}