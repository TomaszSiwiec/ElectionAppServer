package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.dto.CandidateDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandidateMapper {
    public Candidate mapToCandidate(CandidateDto candidateDto) {
        return new Candidate(
                0L,
                candidateDto.getName(),
                candidateDto.getLastname(),
                candidateDto.getElectionList(),
                candidateDto.getElectoralParty()
        );
    }

    public CandidateDto mapToCandidateDto(Candidate candidate) {
        return new CandidateDto(
                candidate.getName(),
                candidate.getLastname(),
                candidate.getElectionList(),
                candidate.getElectoralParty()
        );
    }

    public List<CandidateDto> mapToCadidateDtoList(List<Candidate> candidates) {
        return candidates.stream()
                .map(candidate -> new CandidateDto(
                        candidate.getName(),
                        candidate.getLastname(),
                        candidate.getElectionList(),
                        candidate.getElectoralParty()))
                .collect(Collectors.toList());
    }
}
