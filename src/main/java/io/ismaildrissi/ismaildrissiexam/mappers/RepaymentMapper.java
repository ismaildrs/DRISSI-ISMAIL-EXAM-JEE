package io.ismaildrissi.ismaildrissiexam.mappers;

import io.ismaildrissi.ismaildrissiexam.dtos.RepaymentDTO;
import io.ismaildrissi.ismaildrissiexam.entities.Repayment;
import io.ismaildrissi.ismaildrissiexam.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepaymentMapper {

    private final CreditRepository creditRepository;

    @Autowired
    public RepaymentMapper(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    /**
     * Convert a Repayment entity to a RepaymentDTO.
     *
     * @param entity the entity to convert
     * @return the DTO
     */
    public RepaymentDTO toDto(Repayment entity) {
        if (entity == null) {
            return null;
        }
        
        RepaymentDTO dto = new RepaymentDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setAmount(entity.getAmount());
        dto.setType(entity.getType());
        
        if (entity.getCredit() != null) {
            dto.setCreditId(entity.getCredit().getId());
        }
        
        return dto;
    }

    /**
     * Convert a RepaymentDTO to a Repayment entity.
     *
     * @param dto the DTO to convert
     * @return the entity
     */
    public Repayment toEntity(RepaymentDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Repayment entity = new Repayment();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setAmount(dto.getAmount());
        entity.setType(dto.getType());
        
        if (dto.getCreditId() != null) {
            creditRepository.findById(dto.getCreditId())
                .ifPresent(entity::setCredit);
        }
        
        return entity;
    }
}