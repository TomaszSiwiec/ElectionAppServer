package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectoralProgramme;
import com.pk.electionappserver.domain.dto.ElectoralProgrammeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectoralProgrammeMapper {
    public ElectoralProgramme mapToElectoralProgramme(ElectoralProgrammeDto electoralProgrammeDto) {
        return new ElectoralProgramme(
                electoralProgrammeDto.getId(),
                electoralProgrammeDto.getProgramDescription(),
                electoralProgrammeDto.getElectoralParty()
        );
    }

    public ElectoralProgrammeDto mapToElectoralProgrammeDto(ElectoralProgramme electoralProgramme) {
        return new ElectoralProgrammeDto(
                electoralProgramme.getId(),
                electoralProgramme.getDescription(),
                electoralProgramme.getElectoralParty()
        );
    }

    public List<ElectoralProgrammeDto> mapToElectoralProgrammeDtoList(List<ElectoralProgramme> electoralProgrammes) {
        return electoralProgrammes.stream()
                .map(electoralProgramme -> mapToElectoralProgrammeDto(electoralProgramme))
                .collect(Collectors.toList());
    }
}
