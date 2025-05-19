package io.ismaildrissi.ismaildrissiexam.services.impl;

import io.ismaildrissi.ismaildrissiexam.dtos.RealEstateCreditDTO;
import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit;
import io.ismaildrissi.ismaildrissiexam.mappers.RealEstateCreditMapper;
import io.ismaildrissi.ismaildrissiexam.repositories.CreditRepository;
import io.ismaildrissi.ismaildrissiexam.services.RealEstateCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RealEstateCreditServiceImpl implements RealEstateCreditService {

    private final CreditRepository creditRepository;
    private final RealEstateCreditMapper realEstateCreditMapper;

    @Autowired
    public RealEstateCreditServiceImpl(CreditRepository creditRepository, RealEstateCreditMapper realEstateCreditMapper) {
        this.creditRepository = creditRepository;
        this.realEstateCreditMapper = realEstateCreditMapper;
    }

    @Override
    public RealEstateCreditDTO save(RealEstateCreditDTO realEstateCreditDTO) {
        RealEstateCredit realEstateCredit = realEstateCreditMapper.toEntity(realEstateCreditDTO);
        realEstateCredit = creditRepository.save(realEstateCredit);
        return realEstateCreditMapper.toDto(realEstateCredit);
    }

    @Override
    public List<RealEstateCreditDTO> findAll() {
        return creditRepository.findAll().stream()
                .filter(credit -> credit instanceof RealEstateCredit)
                .map(credit -> realEstateCreditMapper.toDto((RealEstateCredit) credit))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RealEstateCreditDTO> findById(Long id) {
        return creditRepository.findById(id)
                .filter(credit -> credit instanceof RealEstateCredit)
                .map(credit -> realEstateCreditMapper.toDto((RealEstateCredit) credit));
    }

    @Override
    public void delete(Long id) {
        creditRepository.findById(id)
                .filter(credit -> credit instanceof RealEstateCredit)
                .ifPresent(creditRepository::delete);
    }
}