package com.example.cuoiki.service;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.repository.CandidateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CandidateService {
    private EntityManager em;
    private CandidateRepository candidateRepository;
    @Autowired
    public CandidateService(EntityManager entityManager, CandidateRepository candidateRepository) {
        this.em = entityManager;
        this.candidateRepository = candidateRepository;
    }
    public List<Candidate> getAll(){
        return candidateRepository.findAll();
    }
    public List<Candidate> findByCompany(String company){

        TypedQuery<Candidate> query = em.createQuery("select c from Candidate c left join c.experiences e where e.companyName=:company", Candidate.class);
        query.setParameter("company", company);
        return query.getResultList();
    }
    public List<Candidate> findByExperience(){
        TypedQuery<Candidate> query = em.createQuery("select c from Candidate c left join c.experiences e where YEAR(e.toDate)-YEAR(e.fromDate) >=5", Candidate.class);
        return query.getResultList();
    }
}
