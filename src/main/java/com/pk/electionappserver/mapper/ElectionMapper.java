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
                electionDto.getId(),
                electionDto.getStartDate(),
                electionDto.getFinishDate(),
                electionDto.getVoteResult(),
                electionDto.getElectionType(),
                electionDto.getConstituencies()
        );
    }

    public ElectionDto mapToElectionDto(Election election) {
        return new ElectionDto(
                election.getId(),
                election.getStartDate(),
                election.getFinishDate(),
                election.getVoteResult(),
                election.getElectionType(),
                election.getConstituencies()
        );
    }

    public List<ElectionDto> mapToElectionDtoList(List<Election> elections) {
        return elections.stream()
                .map(election -> mapToElectionDto(election))
                .collect(Collectors.toList());
    }
}
