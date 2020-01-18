package com.pk.electionappserver.mapper;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.pk.electionappserver.domain.*;
import com.pk.electionappserver.domain.dto.CandidateDto;
import com.pk.electionappserver.repository.ElectionListRepository;
import com.pk.electionappserver.repository.ElectoralPartyRepository;
import com.pk.electionappserver.repository.VoteResultRepository;
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

    @Autowired
    private VoteResultRepository voteResultRepository;

    @Autowired
    private ElectionListRepository electionListRepository;

    @Autowired
    private ElectoralPartyRepository electoralPartyRepository;

    public Candidate mapToCandidate(CandidateDto candidateDto) {
        if (candidateDto == null) {
            return null;
        }

        Education education = Education.PODSTAWOWE;

        switch (candidateDto.getEducation().toLowerCase()) {
            case "podstawowe":
                education = Education.PODSTAWOWE;
                break;
            case "zawodowe":
                education = Education.ZAWODOWE;
                break;
            case "srednie":
                education = Education.SREDNIE;
                break;
            case "licencjat":
                education = Education.LICENCJAT;
                break;
            case "inzynier":
                education = Education.INZYNIER;
                break;
            case "magister":
                education = Education.MAGISTER;
                break;
            case "doktor":
                education = Education.DOKTOR;
                break;
            case "profesor":
                education = Education.PROFESOR;
                break;
        }

        return new Candidate(
                candidateDto.getId(),
                candidateDto.getName(),
                candidateDto.getLastname(),
                education,
                candidateDto.getPlaceOfResidence(),
                null,
                null,
                null
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
                candidate.getEducation().toString(),
                candidate.getPlaceOfResidence()
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
