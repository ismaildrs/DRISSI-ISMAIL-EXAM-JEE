package io.ismaildrissi.ismaildrissiexam.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PERSONAL")
public class PersonalCredit extends Credit {
    private String reason; // Motif: car purchase, studies, renovations, etc.
}