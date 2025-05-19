package io.ismaildrissi.ismaildrissiexam.repositories;

import io.ismaildrissi.ismaildrissiexam.entities.PersonalCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCreditRepository extends JpaRepository<PersonalCredit, Long> {
}