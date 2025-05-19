package io.ismaildrissi.ismaildrissiexam.services;

import io.ismaildrissi.ismaildrissiexam.entities.Credit;
import io.ismaildrissi.ismaildrissiexam.entities.PersonalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.ProfessionalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit;

import java.util.List;

public interface CreditService {
    // Generic credit operations
    List<Credit> getAllCredits();
    Credit getCreditById(Long id);
    void deleteCredit(Long id);
    
    // Personal credit operations
    List<PersonalCredit> getAllPersonalCredits();
    PersonalCredit getPersonalCreditById(Long id);
    PersonalCredit savePersonalCredit(PersonalCredit personalCredit);
    
    // Real estate credit operations
    List<RealEstateCredit> getAllRealEstateCredits();
    RealEstateCredit getRealEstateCreditById(Long id);
    RealEstateCredit saveRealEstateCredit(RealEstateCredit realEstateCredit);
    
    // Professional credit operations
    List<ProfessionalCredit> getAllProfessionalCredits();
    ProfessionalCredit getProfessionalCreditById(Long id);
    ProfessionalCredit saveProfessionalCredit(ProfessionalCredit professionalCredit);
    
    // Client-related operations
    List<Credit> getCreditsByClientId(Long clientId);
}