package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.dto.CandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandidateMapper {

    @Autowired
    private VoteResultMap voteResultMap;

    @Autowired
    private ElectionListMapper electionListMapper;

    @Autowired
    private ElectoralPartyMapper electoralPartyMapper;

    public Candidate mapToCandidate(CandidateDto candidateDto) {
        if (candidateDto == null) {
            return null;
        }

        return new Candidate(
                candidateDto.getId(),
                candidateDto.getName(),
                candidateDto.getLastname(),
                candidateDto.getEducation(),
                candidateDto.getPlaceOfResidence(),
                voteResultMap.mapToVoteResultList(candidateDto.getVoteResults()),
                electionListMapper.mapToElectionList(candidateDto.getElectionList()),
                electoralPartyMapper.mapToElectoralParty(candidateDto.getElectoralParty())
        );
    }

    public CandidateDto mapToCandidateDto(Candidate candidate) {
        if (candidate == null) {
            return null;
        }
        return new CandidateDto(
                candidate.getId(),
                candidate.getName(),
                candidate.getLastname(),
                candidate.getEducation(),
                candidate.getPlaceOfResidence(),
                voteResultMap.mapToVoteResultDtoList(candidate.getVoteResults()),
                electionListMapper.mapToElectionListDto(candidate.getElectionList()),
                electoralPartyMapper.mapToElectoralPartyDto(candidate.getElectoralParty())
        );
    }

    public List<CandidateDto> mapToCadidateDtoList(List<Candidate> candidates) {
        if (candidates == null) {
            return new ArrayList<>();
        }
        return candidates.stream()
                .map(candidate -> mapToCandidateDto(candidate))
                .collect(Collectors.toList());
    }

    public List<Candidate> mapToCadidateList(List<CandidateDto> candidates) {
        if (candidates == null) {
            return new ArrayList<>();
        }
        return candidates.stream()
                .map(candidate -> mapToCandidate(candidate))
                .collect(Collectors.toList());
    }
}
