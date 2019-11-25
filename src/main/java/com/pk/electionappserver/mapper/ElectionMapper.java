package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Election;
import com.pk.electionappserver.domain.dto.ElectionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectionMapper {
    public Election mapToElection(ElectionDto electionDto) {
        return new Election(
                0L,
                electionDto.getDate(),
                electionDto.getElectionType(),
                electionDto.getConstituencies()
        );
    }

    public ElectionDto mapToElectionDto(Election election) {
        return new ElectionDto(
                election.getDate(),
                election.getElectionType(),
                election.getConstituencies()
        );
    }

    public List<ElectionDto> mapToElectionDtoList(List<Election> elections) {
        return elections.stream()
                .map(election -> new ElectionDto(
                        election.getDate(),
                        election.getElectionType(),
                        election.getConstituencies()))
                .collect(Collectors.toList());
    }
}
