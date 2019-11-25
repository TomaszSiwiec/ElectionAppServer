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
                0L,
                electoralProgrammeDto.getProgramDescription(),
                electoralProgrammeDto.getElectoralParty()
        );
    }

    public ElectoralProgrammeDto mapToElectoralProgrammeDto(ElectoralProgramme electoralProgramme) {
        return new ElectoralProgrammeDto(
                electoralProgramme.getProgramDescription(),
                electoralProgramme.getElectoralParty()
        );
    }

    public List<ElectoralProgrammeDto> mapToElectoralProgrammeDtoList(List<ElectoralProgramme> electoralProgrammes) {
        return electoralProgrammes.stream()
                .map(electoralProgramme -> new ElectoralProgrammeDto(
                        electoralProgramme.getProgramDescription(),
                        electoralProgramme.getElectoralParty()
                ))
                .collect(Collectors.toList());
    }
}
