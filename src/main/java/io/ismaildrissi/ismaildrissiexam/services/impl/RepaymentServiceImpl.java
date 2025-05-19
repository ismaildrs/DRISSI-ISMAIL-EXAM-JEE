package io.ismaildrissi.ismaildrissiexam.services.impl;

import io.ismaildrissi.ismaildrissiexam.dtos.RepaymentDTO;
import io.ismaildrissi.ismaildrissiexam.entities.Repayment;
import io.ismaildrissi.ismaildrissiexam.mappers.RepaymentMapper;
import io.ismaildrissi.ismaildrissiexam.repositories.RepaymentRepository;
import io.ismaildrissi.ismaildrissiexam.services.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RepaymentServiceImpl implements RepaymentService {

    private final RepaymentRepository repaymentRepository;
    private final RepaymentMapper repaymentMapper;

    @Autowired
    public RepaymentServiceImpl(RepaymentRepository repaymentRepository, RepaymentMapper repaymentMapper) {
        this.repaymentRepository = repaymentRepository;
        this.repaymentMapper = repaymentMapper;
    }

    @Override
    public RepaymentDTO save(RepaymentDTO repaymentDTO) {
        Repayment repayment = repaymentMapper.toEntity(repaymentDTO);
        repayment = repaymentRepository.save(repayment);
        return repaymentMapper.toDto(repayment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RepaymentDTO> findAll() {
        return repaymentRepository.findAll().stream()
                .map(repaymentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RepaymentDTO> findById(Long id) {
        return repaymentRepository.findById(id)
                .map(repaymentMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        repaymentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RepaymentDTO> findByCreditId(Long creditId) {
        return repaymentRepository.findAll().stream()
                .filter(repayment -> repayment.getCredit() != null && 
                        repayment.getCredit().getId().equals(creditId))
                .map(repaymentMapper::toDto)
                .collect(Collectors.toList());
    }
}