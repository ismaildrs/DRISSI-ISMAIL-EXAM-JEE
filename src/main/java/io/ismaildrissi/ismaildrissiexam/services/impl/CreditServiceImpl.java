package io.ismaildrissi.ismaildrissiexam.services.impl;

import io.ismaildrissi.ismaildrissiexam.entities.Credit;
import io.ismaildrissi.ismaildrissiexam.entities.PersonalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.ProfessionalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit;
import io.ismaildrissi.ismaildrissiexam.repositories.CreditRepository;
import io.ismaildrissi.ismaildrissiexam.repositories.PersonalCreditRepository;
import io.ismaildrissi.ismaildrissiexam.repositories.ProfessionalCreditRepository;
import io.ismaildrissi.ismaildrissiexam.repositories.RealEstateCreditRepository;
import io.ismaildrissi.ismaildrissiexam.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final PersonalCreditRepository personalCreditRepository;
    private final RealEstateCreditRepository realEstateCreditRepository;
    private final ProfessionalCreditRepository professionalCreditRepository;

    @Autowired
    public CreditServiceImpl(CreditRepository creditRepository,
                            PersonalCreditRepository personalCreditRepository,
                            RealEstateCreditRepository realEstateCreditRepository,
                            ProfessionalCreditRepository professionalCreditRepository) {
        this.creditRepository = creditRepository;
        this.personalCreditRepository = personalCreditRepository;
        this.realEstateCreditRepository = realEstateCreditRepository;
        this.professionalCreditRepository = professionalCreditRepository;
    }

    @Override
    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Credit getCreditById(Long id) {
        return creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + id));
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public List<PersonalCredit> getAllPersonalCredits() {
        return personalCreditRepository.findAll();
    }

    @Override
    public PersonalCredit getPersonalCreditById(Long id) {
        return personalCreditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal credit not found with id: " + id));
    }

    @Override
    public PersonalCredit savePersonalCredit(PersonalCredit personalCredit) {
        return personalCreditRepository.save(personalCredit);
    }

    @Override
    public List<RealEstateCredit> getAllRealEstateCredits() {
        return realEstateCreditRepository.findAll();
    }

    @Override
    public RealEstateCredit getRealEstateCreditById(Long id) {
        return realEstateCreditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Real estate credit not found with id: " + id));
    }

    @Override
    public RealEstateCredit saveRealEstateCredit(RealEstateCredit realEstateCredit) {
        return realEstateCreditRepository.save(realEstateCredit);
    }

    @Override
    public List<ProfessionalCredit> getAllProfessionalCredits() {
        return professionalCreditRepository.findAll();
    }

    @Override
    public ProfessionalCredit getProfessionalCreditById(Long id) {
        return professionalCreditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professional credit not found with id: " + id));
    }

    @Override
    public ProfessionalCredit saveProfessionalCredit(ProfessionalCredit professionalCredit) {
        return professionalCreditRepository.save(professionalCredit);
    }

    @Override
    public List<Credit> getCreditsByClientId(Long clientId) {
        return creditRepository.findAll().stream()
                .filter(credit -> credit.getClient() != null && credit.getClient().getId().equals(clientId))
                .collect(Collectors.toList());
    }
}