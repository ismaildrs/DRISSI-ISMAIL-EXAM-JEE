package io.ismaildrissi.ismaildrissiexam.entities;

import io.ismaildrissi.ismaildrissiexam.enums.CreditStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CREDIT_TYPE")
public abstract class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date requestDate;

    @Enumerated(EnumType.STRING)
    private CreditStatus status;

    @Temporal(TemporalType.DATE)
    private Date acceptanceDate;

    private Double amount;
    private Integer duration; // in months
    private Double interestRate;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Repayment> repayments;
}
