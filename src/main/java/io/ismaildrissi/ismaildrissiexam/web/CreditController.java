package io.ismaildrissi.ismaildrissiexam.web;

import io.ismaildrissi.ismaildrissiexam.entities.Credit;
import io.ismaildrissi.ismaildrissiexam.entities.PersonalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.ProfessionalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit;
import io.ismaildrissi.ismaildrissiexam.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    // Generic credit endpoints
    @GetMapping
    public List<Credit> getAllCredits() {
        return creditService.getAllCredits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credit> getCreditById(@PathVariable Long id) {
        Credit credit = creditService.getCreditById(id);
        return ResponseEntity.ok(credit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client/{clientId}")
    public List<Credit> getCreditsByClientId(@PathVariable Long clientId) {
        return creditService.getCreditsByClientId(clientId);
    }

    // Personal credit endpoints
    @GetMapping("/personal")
    public List<PersonalCredit> getAllPersonalCredits() {
        return creditService.getAllPersonalCredits();
    }

    @GetMapping("/personal/{id}")
    public ResponseEntity<PersonalCredit> getPersonalCreditById(@PathVariable Long id) {
        PersonalCredit credit = creditService.getPersonalCreditById(id);
        return ResponseEntity.ok(credit);
    }

    @PostMapping("/personal")
    public ResponseEntity<PersonalCredit> createPersonalCredit(@RequestBody PersonalCredit credit) {
        PersonalCredit savedCredit = creditService.savePersonalCredit(credit);
        return ResponseEntity.ok(savedCredit);
    }

    @PutMapping("/personal/{id}")
    public ResponseEntity<PersonalCredit> updatePersonalCredit(@PathVariable Long id, @RequestBody PersonalCredit credit) {
        credit.setId(id);
        PersonalCredit updatedCredit = creditService.savePersonalCredit(credit);
        return ResponseEntity.ok(updatedCredit);
    }

    // Real estate credit endpoints
    @GetMapping("/realestate")
    public List<RealEstateCredit> getAllRealEstateCredits() {
        return creditService.getAllRealEstateCredits();
    }

    @GetMapping("/realestate/{id}")
    public ResponseEntity<RealEstateCredit> getRealEstateCreditById(@PathVariable Long id) {
        RealEstateCredit credit = creditService.getRealEstateCreditById(id);
        return ResponseEntity.ok(credit);
    }

    @PostMapping("/realestate")
    public ResponseEntity<RealEstateCredit> createRealEstateCredit(@RequestBody RealEstateCredit credit) {
        RealEstateCredit savedCredit = creditService.saveRealEstateCredit(credit);
        return ResponseEntity.ok(savedCredit);
    }

    @PutMapping("/realestate/{id}")
    public ResponseEntity<RealEstateCredit> updateRealEstateCredit(@PathVariable Long id, @RequestBody RealEstateCredit credit) {
        credit.setId(id);
        RealEstateCredit updatedCredit = creditService.saveRealEstateCredit(credit);
        return ResponseEntity.ok(updatedCredit);
    }

    // Professional credit endpoints
    @GetMapping("/professional")
    public List<ProfessionalCredit> getAllProfessionalCredits() {
        return creditService.getAllProfessionalCredits();
    }

    @GetMapping("/professional/{id}")
    public ResponseEntity<ProfessionalCredit> getProfessionalCreditById(@PathVariable Long id) {
        ProfessionalCredit credit = creditService.getProfessionalCreditById(id);
        return ResponseEntity.ok(credit);
    }

    @PostMapping("/professional")
    public ResponseEntity<ProfessionalCredit> createProfessionalCredit(@RequestBody ProfessionalCredit credit) {
        ProfessionalCredit savedCredit = creditService.saveProfessionalCredit(credit);
        return ResponseEntity.ok(savedCredit);
    }

    @PutMapping("/professional/{id}")
    public ResponseEntity<ProfessionalCredit> updateProfessionalCredit(@PathVariable Long id, @RequestBody ProfessionalCredit credit) {
        credit.setId(id);
        ProfessionalCredit updatedCredit = creditService.saveProfessionalCredit(credit);
        return ResponseEntity.ok(updatedCredit);
    }
}