package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Election;
import com.pk.electionappserver.domain.dto.ElectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectionMapper {

    @Autowired
    private VoteResultMap voteResultMap;

    @Autowired
    private ElectionTypeMapper electionTypeMapper;

    @Autowired
    private ConstituencyMapper constituencyMapper;

    public Election mapToElection(ElectionDto electionDto) {
        if (electionDto == null) {
            return null;
        }
        return new Election(
                electionDto.getId(),
                electionDto.getStartDate(),
                electionDto.getFinishDate(),
                voteResultMap.mapToVoteResultList(electionDto.getVoteResults()),
                electionTypeMapper.mapToElectionType(electionDto.getElectionType()),
                constituencyMapper.mapToConstituencyList(electionDto.getConstituencies())
        );
    }

    public ElectionDto mapToElectionDto(Election election) {
        if (election == null) {
            return null;
        }
        return new ElectionDto(
                election.getId(),
                election.getStartDate(),
                election.getFinishDate(),
                voteResultMap.mapToVoteResultDtoList(election.getVoteResults()),
                electionTypeMapper.mapToElectionTypeDto(election.getElectionType()),
                constituencyMapper.mapToConstituencyDtoList(election.getConstituencies())
        );
    }

    public List<ElectionDto> mapToElectionDtoList(List<Election> elections) {
        if (elections == null) {
            return new ArrayList<>();
        }
        return elections.stream()
                .map(election -> mapToElectionDto(election))
                .collect(Collectors.toList());
    }

    public List<Election> mapToElectionList(List<ElectionDto> elections) {
        if (elections == null) {
            return new ArrayList<>();
        }
        return elections.stream()
                .map(election -> mapToElection(election))
                .collect(Collectors.toList());
    }
}
