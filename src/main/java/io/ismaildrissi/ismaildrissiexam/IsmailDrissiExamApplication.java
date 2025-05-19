package io.ismaildrissi.ismaildrissiexam;

import io.ismaildrissi.ismaildrissiexam.entities.Client;
import io.ismaildrissi.ismaildrissiexam.entities.Credit;
import io.ismaildrissi.ismaildrissiexam.entities.PersonalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.ProfessionalCredit;
import io.ismaildrissi.ismaildrissiexam.entities.RealEstateCredit;
import io.ismaildrissi.ismaildrissiexam.enums.CreditStatus;
import io.ismaildrissi.ismaildrissiexam.repositories.*;
import lombok.Locked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class IsmailDrissiExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsmailDrissiExamApplication.class, args);
    }

    @Bean
    CommandLineRunner testDAOLayer(
            ClientRepository clientRepository,
            CreditRepository creditRepository,
            RepaymentRepository repaymentRepository) {
        return args -> {
            Client client = new Client();
            client.setName("Test Client");
            client.setEmail("test@example.com");
            clientRepository.save(client);
            System.out.println("Created client: " + client);

            Client foundClient = clientRepository.findById(client.getId()).orElse(null);
            System.out.println("Found client by ID: " + foundClient);

            List<Client> allClients = clientRepository.findAll();
            System.out.println("All clients count: " + allClients.size());

            System.out.println("\nTesting PersonalCreditRepository...");

            PersonalCredit personalCredit = new PersonalCredit();
            personalCredit.setAmount(10000.0);
            personalCredit.setDuration(12);
            personalCredit.setInterestRate(5.0);
            personalCredit.setRequestDate(new Date());
            personalCredit.setStatus(CreditStatus.PENDING);
            personalCredit.setClient(client);
            creditRepository.save(personalCredit);
            System.out.println("Created personal credit: " + personalCredit);

            PersonalCredit foundPersonalCredit = (PersonalCredit) creditRepository.findById(personalCredit.getId()).orElse(null);
            System.out.println("Found personal credit by ID: " + foundPersonalCredit);

            System.out.println("\nTesting ProfessionalCreditRepository...");

            ProfessionalCredit professionalCredit = new ProfessionalCredit();
            professionalCredit.setAmount(50000.0);
            professionalCredit.setDuration(24);
            professionalCredit.setInterestRate(7.5);
            professionalCredit.setRequestDate(new Date());
            professionalCredit.setStatus(CreditStatus.PENDING);
            professionalCredit.setClient(client);
            creditRepository.save(professionalCredit);
            System.out.println("Created professional credit: " + professionalCredit);

            ProfessionalCredit foundProfessionalCredit = (ProfessionalCredit) creditRepository.findById(professionalCredit.getId()).orElse(null);
            System.out.println("Found professional credit by ID: " + foundProfessionalCredit);

            System.out.println("\nTesting RealEstateCreditRepository...");

            RealEstateCredit realEstateCredit = new RealEstateCredit();
            realEstateCredit.setAmount(200000.0);
            realEstateCredit.setDuration(240);
            realEstateCredit.setInterestRate(3.5);
            realEstateCredit.setRequestDate(new Date());
            realEstateCredit.setStatus(CreditStatus.PENDING);
            realEstateCredit.setClient(client);
            creditRepository.save(realEstateCredit);
            System.out.println("Created real estate credit: " + realEstateCredit);

            RealEstateCredit foundRealEstateCredit = (RealEstateCredit) creditRepository.findById(realEstateCredit.getId()).orElse(null);
            System.out.println("Found real estate credit by ID: " + foundRealEstateCredit);

            System.out.println("\nTesting CreditRepository...");

            List<Credit> allCredits = creditRepository.findAll();
            System.out.println("All credits count: " + allCredits.size());

            System.out.println("\n=== DAO Layer Testing Completed ===");
        };
    }
}