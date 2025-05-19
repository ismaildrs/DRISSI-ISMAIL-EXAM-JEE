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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CREDIT_TYPE")
public abstract class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date requestDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CreditStatus status;

    @Temporal(TemporalType.DATE)
    private Date acceptanceDate;

    private Double amount;
    private Integer duration; // in months
    private Double interestRate;

    @ManyToOne
    private Client client;

    @ToString.Exclude
    @OneToMany(mappedBy = "credit", fetch = FetchType.LAZY)
    private List<Repayment> repayments;
}
