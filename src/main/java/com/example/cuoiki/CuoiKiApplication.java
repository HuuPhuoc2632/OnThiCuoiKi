package com.example.cuoiki;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.models.Experience;
import com.example.cuoiki.repository.CandidateRepository;
import com.example.cuoiki.repository.ExperienceRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.Random;

@SpringBootApplication
public class CuoiKiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuoiKiApplication.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ExperienceRepository experienceRepository;

//    @Bean
//    CommandLineRunner commandLineRunner(CandidateRepository candidateRepository, ExperienceRepository experienceRepository) {
//        return args -> {
//            Faker faker = new Faker();
//            Random random = new Random();
//            Roles roles = Roles.values()[random.nextInt(4) + 1];
//            for (int i = 1; i <= 3; i++) {
//                long candidateId = random.nextInt(3) + 1;
//                Candidate candidate = Candidate.builder().fullName(faker.name().fullName()).phone(faker.phoneNumber().phoneNumber()).email(faker.internet().emailAddress()).build();
//                candidateRepository.save(candidate);
//                int year = random.nextInt(10) + 1;
//                Date fromDate = new Date(faker.date().birthday().getTime());
//                Date toDate = new Date(faker.date().birthday().getTime());
//                toDate.setYear(fromDate.getYear() + year );
//                Experience experience = Experience.builder().fromDate(fromDate).toDate(toDate).companyName(faker.company().name()).workDescription(faker.toString()).role(roles).candidate(candidate).build();
//                experienceRepository.save(experience);
//            }
//        };
//    }
}
