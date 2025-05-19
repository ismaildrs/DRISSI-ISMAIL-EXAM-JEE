package io.ismaildrissi.ismaildrissiexam.mappers;

import io.ismaildrissi.ismaildrissiexam.dtos.PersonalCreditDTO;
import io.ismaildrissi.ismaildrissiexam.entities.PersonalCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonalCreditMapper implements CreditMapper<PersonalCredit, PersonalCreditDTO> {

    private final ClientMapper clientMapper;

    @Autowired
    public PersonalCreditMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public PersonalCreditDTO toDto(PersonalCredit entity) {
        if (entity == null) {
            return null;
        }
        
        PersonalCreditDTO dto = new PersonalCreditDTO();
        dto.setId(entity.getId());
        dto.setRequestDate(entity.getRequestDate());
        dto.setStatus(entity.getStatus());
        dto.setAcceptanceDate(entity.getAcceptanceDate());
        dto.setAmount(entity.getAmount());
        dto.setDuration(entity.getDuration());
        dto.setInterestRate(entity.getInterestRate());
        dto.setClient(clientMapper.toDto(entity.getClient()));
        dto.setReason(entity.getReason());
        
        return dto;
    }

    @Override
    public PersonalCredit toEntity(PersonalCreditDTO dto) {
        if (dto == null) {
            return null;
        }
        
        PersonalCredit entity = new PersonalCredit();
        entity.setId(dto.getId());
        entity.setRequestDate(dto.getRequestDate());
        entity.setStatus(dto.getStatus());
        entity.setAcceptanceDate(dto.getAcceptanceDate());
        entity.setAmount(dto.getAmount());
        entity.setDuration(dto.getDuration());
        entity.setInterestRate(dto.getInterestRate());
        entity.setClient(clientMapper.toEntity(dto.getClient()));
        entity.setReason(dto.getReason());
        
        return entity;
    }
}