package io.ismaildrissi.ismaildrissiexam.mappers;

import io.ismaildrissi.ismaildrissiexam.dtos.ProfessionalCreditDTO;
import io.ismaildrissi.ismaildrissiexam.entities.ProfessionalCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalCreditMapper implements CreditMapper<ProfessionalCredit, ProfessionalCreditDTO> {

    private final ClientMapper clientMapper;

    @Autowired
    public ProfessionalCreditMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public ProfessionalCreditDTO toDto(ProfessionalCredit entity) {
        if (entity == null) {
            return null;
        }
        
        ProfessionalCreditDTO dto = new ProfessionalCreditDTO();
        dto.setId(entity.getId());
        dto.setRequestDate(entity.getRequestDate());
        dto.setStatus(entity.getStatus());
        dto.setAcceptanceDate(entity.getAcceptanceDate());
        dto.setAmount(entity.getAmount());
        dto.setDuration(entity.getDuration());
        dto.setInterestRate(entity.getInterestRate());
        dto.setClient(clientMapper.toDto(entity.getClient()));
        dto.setReason(entity.getReason());
        dto.setCompanyName(entity.getCompanyName());
        
        return dto;
    }

    @Override
    public ProfessionalCredit toEntity(ProfessionalCreditDTO dto) {
        if (dto == null) {
            return null;
        }
        
        ProfessionalCredit entity = new ProfessionalCredit();
        entity.setId(dto.getId());
        entity.setRequestDate(dto.getRequestDate());
        entity.setStatus(dto.getStatus());
        entity.setAcceptanceDate(dto.getAcceptanceDate());
        entity.setAmount(dto.getAmount());
        entity.setDuration(dto.getDuration());
        entity.setInterestRate(dto.getInterestRate());
        entity.setClient(clientMapper.toEntity(dto.getClient()));
        entity.setReason(dto.getReason());
        entity.setCompanyName(dto.getCompanyName());
        
        return entity;
    }
}