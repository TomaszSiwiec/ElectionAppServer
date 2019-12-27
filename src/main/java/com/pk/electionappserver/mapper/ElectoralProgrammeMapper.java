package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectoralProgramme;
import com.pk.electionappserver.domain.dto.ElectoralProgrammeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectoralProgrammeMapper {

    @Autowired
    private ElectoralPartyMapper electoralPartyMapper;

    public ElectoralProgramme mapToElectoralProgramme(ElectoralProgrammeDto electoralProgrammeDto) {
        if (electoralProgrammeDto == null) {
            return null;
        }
        return new ElectoralProgramme(
                electoralProgrammeDto.getId(),
                electoralProgrammeDto.getProgramDescription(),
                electoralPartyMapper.mapToElectoralParty(electoralProgrammeDto.getElectoralParty())
        );
    }

    public ElectoralProgrammeDto mapToElectoralProgrammeDto(ElectoralProgramme electoralProgramme) {
        if (electoralProgramme == null) {
            return null;
        }
        return new ElectoralProgrammeDto(
                electoralProgramme.getId(),
                electoralProgramme.getDescription(),
                electoralPartyMapper.mapToElectoralPartyDto(electoralProgramme.getElectoralParty())
        );
    }

    public List<ElectoralProgrammeDto> mapToElectoralProgrammeDtoList(List<ElectoralProgramme> electoralProgrammes) {
        if (electoralProgrammes == null) {
            return new ArrayList<>();
        }
        return electoralProgrammes.stream()
                .map(electoralProgramme -> mapToElectoralProgrammeDto(electoralProgramme))
                .collect(Collectors.toList());
    }
}
