package io.ismaildrissi.ismaildrissiexam.services.impl;

import io.ismaildrissi.ismaildrissiexam.dtos.ProfessionalCreditDTO;
import io.ismaildrissi.ismaildrissiexam.entities.ProfessionalCredit;
import io.ismaildrissi.ismaildrissiexam.mappers.ProfessionalCreditMapper;
import io.ismaildrissi.ismaildrissiexam.repositories.CreditRepository;
import io.ismaildrissi.ismaildrissiexam.services.ProfessionalCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfessionalCreditServiceImpl implements ProfessionalCreditService {

    private final CreditRepository creditRepository;
    private final ProfessionalCreditMapper professionalCreditMapper;

    @Autowired
    public ProfessionalCreditServiceImpl(CreditRepository creditRepository, ProfessionalCreditMapper professionalCreditMapper) {
        this.creditRepository = creditRepository;
        this.professionalCreditMapper = professionalCreditMapper;
    }

    @Override
    public ProfessionalCreditDTO save(ProfessionalCreditDTO professionalCreditDTO) {
        ProfessionalCredit professionalCredit = professionalCreditMapper.toEntity(professionalCreditDTO);
        professionalCredit = creditRepository.save(professionalCredit);
        return professionalCreditMapper.toDto(professionalCredit);
    }

    @Override
    public List<ProfessionalCreditDTO> findAll() {
        return creditRepository.findAll().stream()
                .filter(credit -> credit instanceof ProfessionalCredit)
                .map(credit -> professionalCreditMapper.toDto((ProfessionalCredit) credit))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProfessionalCreditDTO> findById(Long id) {
        return creditRepository.findById(id)
                .filter(credit -> credit instanceof ProfessionalCredit)
                .map(credit -> professionalCreditMapper.toDto((ProfessionalCredit) credit));
    }

    @Override
    public void delete(Long id) {
        creditRepository.findById(id)
                .filter(credit -> credit instanceof ProfessionalCredit)
                .ifPresent(creditRepository::delete);
    }
}