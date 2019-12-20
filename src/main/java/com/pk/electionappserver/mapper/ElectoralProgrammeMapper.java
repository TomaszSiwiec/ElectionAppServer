package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectoralProgramme;
import com.pk.electionappserver.domain.dto.ElectoralProgrammeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectoralProgrammeMapper {

    @Autowired
    private ElectoralPartyMapper electoralPartyMapper;

    public ElectoralProgramme mapToElectoralProgramme(ElectoralProgrammeDto electoralProgrammeDto) {
        return new ElectoralProgramme(
                electoralProgrammeDto.getId(),
                electoralProgrammeDto.getProgramDescription(),
                electoralPartyMapper.mapToElectoralParty(electoralProgrammeDto.getElectoralParty())
        );
    }

    public ElectoralProgrammeDto mapToElectoralProgrammeDto(ElectoralProgramme electoralProgramme) {
        return new ElectoralProgrammeDto(
                electoralProgramme.getId(),
                electoralProgramme.getDescription(),
                electoralPartyMapper.mapToElectoralPartyDto(electoralProgramme.getElectoralParty())
        );
    }

    public List<ElectoralProgrammeDto> mapToElectoralProgrammeDtoList(List<ElectoralProgramme> electoralProgrammes) {
        return electoralProgrammes.stream()
                .map(electoralProgramme -> mapToElectoralProgrammeDto(electoralProgramme))
                .collect(Collectors.toList());
    }
}
