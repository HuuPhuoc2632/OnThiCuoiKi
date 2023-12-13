package com.example.cuoiki.controller;

import com.example.cuoiki.models.Candidate;
import com.example.cuoiki.repository.CandidateRepository;
import com.example.cuoiki.repository.ExperienceRepository;
import com.example.cuoiki.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ExperienceRepository  experienceRepository;
    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/list-candidate")
    public String listCandidate(Model model) {
        List<Candidate> candidates = candidateRepository.findAll();
        model.addAttribute("candidates", candidates);
        return "Candidates";
    }
    @GetMapping("/detail/{id}")
    public String CanDetail(@PathVariable("id") long id, Model model){
        System.out.println(id);
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        System.out.println(candidate);
        model.addAttribute("candidate", candidate);
        return "Can_detail";
    }
    @GetMapping("/find-candidate/{company}")
    @Secured("USER")
    public String findCandidate(@RequestParam String company, Model model){
        System.out.println(company);
        List<Candidate> candidates = candidateService.findByCompany(company);
        System.out.println(candidates.size());
        model.addAttribute("candidates", candidates);
        return "Report1";
    }
    @GetMapping("/report1")
    public String report1(Model model){
        return "Report1";
    }
    @GetMapping("/find-experience")
    @Secured("ADMIN")
    public String findExperience( Model model){
        List<Candidate> candidates = candidateService.findByExperience();
        System.out.println(candidates.size());
        model.addAttribute("candidates", candidates);
        return "Report2";
    }

}
