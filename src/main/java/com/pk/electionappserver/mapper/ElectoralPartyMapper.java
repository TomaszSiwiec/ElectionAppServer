package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectoralParty;
import com.pk.electionappserver.domain.dto.ElectoralPartyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectoralPartyMapper {

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private ElectoralProgrammeMapper electoralProgrammeMapper;

    public ElectoralParty mapToElectoralParty(ElectoralPartyDto electoralPartyDto) {
        return new ElectoralParty(
                electoralPartyDto.getId(),
                electoralPartyDto.getName(),
                electoralPartyDto.getDescription(),
                candidateMapper.mapToCadidateList(electoralPartyDto.getCandidates()),
                electoralProgrammeMapper.mapToElectoralProgramme(electoralPartyDto.getElectoralProgramme())
        );
    }

    public ElectoralPartyDto mapToElectoralPartyDto(ElectoralParty electoralParty) {
        return new ElectoralPartyDto(
                electoralParty.getId(),
                electoralParty.getName(),
                electoralParty.getDescription(),
                candidateMapper.mapToCadidateDtoList(electoralParty.getCandidates()),
                electoralProgrammeMapper.mapToElectoralProgrammeDto(electoralParty.getElectoralProgramme())
        );
    }

    public List<ElectoralPartyDto> mapToElectoralPartyDtoList(List<ElectoralParty> electoralParties) {
        return electoralParties.stream()
                .map(electoralParty -> mapToElectoralPartyDto(electoralParty))
                .collect(Collectors.toList());
    }
}
