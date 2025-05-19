package io.ismaildrissi.ismaildrissiexam.mappers;

import io.ismaildrissi.ismaildrissiexam.dtos.CreditDTO;
import io.ismaildrissi.ismaildrissiexam.entities.Credit;

public interface CreditMapper<E extends Credit, D extends CreditDTO> {

    D toDto(E entity);
    E toEntity(D dto);
}