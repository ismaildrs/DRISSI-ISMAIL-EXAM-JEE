package io.ismaildrissi.ismaildrissiexam.web;

import io.ismaildrissi.ismaildrissiexam.dtos.CreditDTO;
import io.ismaildrissi.ismaildrissiexam.dtos.PersonalCreditDTO;
import io.ismaildrissi.ismaildrissiexam.dtos.ProfessionalCreditDTO;
import io.ismaildrissi.ismaildrissiexam.dtos.RealEstateCreditDTO;
import io.ismaildrissi.ismaildrissiexam.services.PersonalCreditService;
import io.ismaildrissi.ismaildrissiexam.services.ProfessionalCreditService;
import io.ismaildrissi.ismaildrissiexam.services.RealEstateCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    private final PersonalCreditService personalCreditService;
    private final ProfessionalCreditService professionalCreditService;
    private final RealEstateCreditService realEstateCreditService;

    @Autowired
    public CreditController(PersonalCreditService personalCreditService,
                            ProfessionalCreditService professionalCreditService,
                            RealEstateCreditService realEstateCreditService) {
        this.personalCreditService = personalCreditService;
        this.professionalCreditService = professionalCreditService;
        this.realEstateCreditService = realEstateCreditService;
    }

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        List<CreditDTO> allCredits = new ArrayList<>();
        allCredits.addAll(personalCreditService.findAll());
        allCredits.addAll(professionalCreditService.findAll());
        allCredits.addAll(realEstateCreditService.findAll());
        return allCredits;
    }

    @GetMapping("/{id}")
    public CreditDTO getCreditById(@PathVariable Long id) {
        Optional<PersonalCreditDTO> personalCredit = personalCreditService.findById(id);
        if (personalCredit.isPresent()) {
            return personalCredit.get();
        }

        Optional<ProfessionalCreditDTO> professionalCredit = professionalCreditService.findById(id);
        if (professionalCredit.isPresent()) {
            return professionalCredit.get();
        }

        Optional<RealEstateCreditDTO> realEstateCredit = realEstateCreditService.findById(id);
        if (realEstateCredit.isPresent()) {
            return realEstateCredit.get();
        }
        return null;
    }

    @PostMapping("/personal")
    public CreditDTO createPersonalCredit(@RequestBody PersonalCreditDTO creditDTO) {
        return personalCreditService.save(creditDTO);
    }

    @PostMapping("/professional")
    public CreditDTO createProfessionalCredit(@RequestBody ProfessionalCreditDTO creditDTO) {
        return professionalCreditService.save(creditDTO);
    }

    @PostMapping("/realestate")
    public CreditDTO createRealEstateCredit(@RequestBody RealEstateCreditDTO creditDTO) {
        return realEstateCreditService.save(creditDTO);
    }

    @PutMapping("/personal/{id}")
    public CreditDTO updatePersonalCredit(@PathVariable Long id, @RequestBody PersonalCreditDTO creditDTO) {
        creditDTO.setId(id);
        return personalCreditService.save(creditDTO);
    }

    @PutMapping("/professional/{id}")
    public CreditDTO updateProfessionalCredit(@PathVariable Long id, @RequestBody ProfessionalCreditDTO creditDTO) {
        creditDTO.setId(id);
        return professionalCreditService.save(creditDTO);
    }

    @PutMapping("/realestate/{id}")
    public CreditDTO updateRealEstateCredit(@PathVariable Long id, @RequestBody RealEstateCreditDTO creditDTO) {
        creditDTO.setId(id);
        return realEstateCreditService.save(creditDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        Optional<PersonalCreditDTO> personalCredit = personalCreditService.findById(id);
        if (personalCredit.isPresent()) {
            personalCreditService.delete(id);
            return;
        }

        Optional<ProfessionalCreditDTO> professionalCredit = professionalCreditService.findById(id);
        if (professionalCredit.isPresent()) {
            professionalCreditService.delete(id);
            return;
        }

        Optional<RealEstateCreditDTO> realEstateCredit = realEstateCreditService.findById(id);
        if (realEstateCredit.isPresent()) {
            realEstateCreditService.delete(id);
        }
    }
}