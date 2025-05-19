package io.ismaildrissi.ismaildrissiexam.repositories;

import io.ismaildrissi.ismaildrissiexam.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}