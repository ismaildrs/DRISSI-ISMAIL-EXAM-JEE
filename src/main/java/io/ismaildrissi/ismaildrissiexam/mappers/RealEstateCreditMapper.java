package io.ismaildrissi.ismaildrissiexam.mappers;

import io.ismaildrissi.ismaildrissiexam.dtos.RealEstateCreditDTO;
import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RealEstateCreditMapper implements CreditMapper<RealEstateCredit, RealEstateCreditDTO> {

    private final ClientMapper clientMapper;

    @Autowired
    public RealEstateCreditMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public RealEstateCreditDTO toDto(RealEstateCredit entity) {
        if (entity == null) {
            return null;
        }
        
        RealEstateCreditDTO dto = new RealEstateCreditDTO();
        dto.setId(entity.getId());
        dto.setRequestDate(entity.getRequestDate());
        dto.setStatus(entity.getStatus());
        dto.setAcceptanceDate(entity.getAcceptanceDate());
        dto.setAmount(entity.getAmount());
        dto.setDuration(entity.getDuration());
        dto.setInterestRate(entity.getInterestRate());
        dto.setClient(clientMapper.toDto(entity.getClient()));
        dto.setPropertyType(entity.getPropertyType());
        
        return dto;
    }

    @Override
    public RealEstateCredit toEntity(RealEstateCreditDTO dto) {
        if (dto == null) {
            return null;
        }
        
        RealEstateCredit entity = new RealEstateCredit();
        entity.setId(dto.getId());
        entity.setRequestDate(dto.getRequestDate());
        entity.setStatus(dto.getStatus());
        entity.setAcceptanceDate(dto.getAcceptanceDate());
        entity.setAmount(dto.getAmount());
        entity.setDuration(dto.getDuration());
        entity.setInterestRate(dto.getInterestRate());
        entity.setClient(clientMapper.toEntity(dto.getClient()));
        entity.setPropertyType(dto.getPropertyType());
        
        return entity;
    }
}