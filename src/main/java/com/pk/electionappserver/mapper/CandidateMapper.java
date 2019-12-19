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
                candidateDto.getId(),
                candidateDto.getName(),
                candidateDto.getLastname(),
                candidateDto.getEducation(),
                candidateDto.getPlaceOfResidence(),
                candidateDto.getVoteResult(),
                candidateDto.getElectionList(),
                candidateDto.getElectoralParty()
        );
    }

    public CandidateDto mapToCandidateDto(Candidate candidate) {
        return new CandidateDto(
                candidate.getId(),
                candidate.getName(),
                candidate.getLastname(),
                candidate.getEducation(),
                candidate.getPlaceOfResidence(),
                candidate.getVoteResult(),
                candidate.getElectionList(),
                candidate.getElectoralParty()
        );
    }

    public List<CandidateDto> mapToCadidateDtoList(List<Candidate> candidates) {
        return candidates.stream()
                .map(candidate -> mapToCandidateDto(candidate))
                .collect(Collectors.toList());
    }
}
