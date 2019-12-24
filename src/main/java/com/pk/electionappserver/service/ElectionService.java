package com.pk.electionappserver.service;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.EntityNotFoundException;
import com.pk.electionappserver.domain.dto.CandidateDto;
import com.pk.electionappserver.mapper.CandidateMapper;
import com.pk.electionappserver.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateMapper candidateMapper;

    public List<CandidateDto> getCandidates() {
        return candidateMapper.mapToCadidateDtoList(candidateRepository.findAll());
    }

    public CandidateDto getCandidate(long id) throws EntityNotFoundException {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return candidateMapper.mapToCandidateDto(candidate);
    }

    public Candidate createCandidate(CandidateDto candidateDto) {
        return candidateRepository.save(candidateMapper.mapToCandidate(candidateDto));
    }
}
