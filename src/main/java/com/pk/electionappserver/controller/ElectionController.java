package com.pk.electionappserver.controller;

import com.pk.electionappserver.domain.EntityNotFoundException;
import com.pk.electionappserver.domain.dto.CandidateDto;
import com.pk.electionappserver.domain.dto.ConstituencyDto;
import com.pk.electionappserver.service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/election")
public class ElectionController {

    @Autowired
    private ElectionService service;

    //Candidate
    @GetMapping(value = "/getCandidates")
    public List<CandidateDto> getCandidates() {
        return service.getCandidates();
    }

    @GetMapping(value = "/getCandidate/{candidateId}")
    public CandidateDto getCandidate(@PathVariable long candidateId) throws EntityNotFoundException {
        return service.getCandidate(candidateId);
    }

    @DeleteMapping(value = "/deleteCandidate/{candidateId}")
    public void deleteCandidate(@PathVariable long candidateId) {
        service.deleteCandidateById(candidateId);
    }

    @PostMapping(value = "/createCandidate")
    public void createCandidate(@RequestBody CandidateDto candidateDto) {
        service.createCandidate(candidateDto);
    }

    //Constituency
    @GetMapping(value = "/getConstituencies")
    public List<ConstituencyDto> getConstituencies() {
        return service.getConstituencies();
    }

    @GetMapping(value = "/getConstituency/{constituencyId}")
    public ConstituencyDto getConstituency(@PathVariable long constituencyId) throws EntityNotFoundException {
        return service.getConstituency(constituencyId);
    }

    @DeleteMapping(value = "/deleteConstituency/{constituencyId}")
    public void deleteConstituency(@PathVariable long constituencyId) {
        service.deleteConstituencyById(constituencyId);
    }

    @PostMapping(value = "/createConstituency")
    public void createConstituency(@RequestBody ConstituencyDto constituencyDto) {
        service.createConstituency(constituencyDto);
    }
}
