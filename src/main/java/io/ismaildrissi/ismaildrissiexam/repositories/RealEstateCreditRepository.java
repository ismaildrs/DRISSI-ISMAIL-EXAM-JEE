package io.ismaildrissi.ismaildrissiexam.repositories;

import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealEstateCreditRepository extends JpaRepository<RealEstateCredit, Long> {
}