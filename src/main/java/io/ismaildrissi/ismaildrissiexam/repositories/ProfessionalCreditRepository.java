package io.ismaildrissi.ismaildrissiexam.repositories;

import io.ismaildrissi.ismaildrissiexam.entities.ProfessionalCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalCreditRepository extends JpaRepository<ProfessionalCredit, Long> {
}