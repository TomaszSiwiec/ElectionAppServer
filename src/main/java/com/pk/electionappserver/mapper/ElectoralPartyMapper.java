package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.ElectoralParty;
import com.pk.electionappserver.domain.dto.ElectoralPartyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectoralPartyMapper {

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private ElectoralProgrammeMapper electoralProgrammeMapper;

    @Autowired
    private ElectionListMapper electionListMapper;

    public ElectoralParty mapToElectoralParty(ElectoralPartyDto electoralPartyDto) {
        if (electoralPartyDto == null) {
            return null;
        }
        return new ElectoralParty(
                electoralPartyDto.getId(),
                electoralPartyDto.getName(),
                electoralPartyDto.getDescription(),
                candidateMapper.mapToCadidateList(electoralPartyDto.getCandidates()),
                electoralProgrammeMapper.mapToElectoralProgramme(electoralPartyDto.getElectoralProgramme()),
                electionListMapper.mapToElectionListList(electoralPartyDto.getElectionListsDto())
        );
    }

    public ElectoralPartyDto mapToElectoralPartyDto(ElectoralParty electoralParty) {
        if (electoralParty == null) {
            return null;
        }
        return new ElectoralPartyDto(
                electoralParty.getId(),
                electoralParty.getName(),
                electoralParty.getDescription(),
                candidateMapper.mapToCadidateDtoList(electoralParty.getCandidates()),
                electoralProgrammeMapper.mapToElectoralProgrammeDto(electoralParty.getElectoralProgramme()),
                electionListMapper.mapToElectionListDtoList(electoralParty.getElectionLists())
        );
    }

    public List<ElectoralPartyDto> mapToElectoralPartyDtoList(List<ElectoralParty> electoralParties) {
        if (electoralParties == null) {
            return new ArrayList<>();
        }
        return electoralParties.stream()
                .map(electoralParty -> mapToElectoralPartyDto(electoralParty))
                .collect(Collectors.toList());
    }
}
