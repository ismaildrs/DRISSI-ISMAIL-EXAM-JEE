package io.ismaildrissi.ismaildrissiexam.repositories;

import io.ismaildrissi.ismaildrissiexam.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
}