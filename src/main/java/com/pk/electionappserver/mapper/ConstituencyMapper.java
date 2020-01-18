package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Constituency;
import com.pk.electionappserver.domain.dto.ConstituencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConstituencyMapper {

    @Autowired
    private ElectionMapper electionMapper;

    @Autowired
    private ElectionListMapper electionListMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private VoteResultMap voteResultMapper;

    public Constituency mapToConstituency(ConstituencyDto constituencyDto) {
        if (constituencyDto == null) {
            return null;
        }
        return new Constituency(
                constituencyDto.getId(),
                constituencyDto.getName(),
                constituencyDto.getDescription(),
                electionMapper.mapToElection(constituencyDto.getElection()),
                electionListMapper.mapToElectionListList(constituencyDto.getElectionLists()),
                cityMapper.mapToCityList(constituencyDto.getCityList()),
                voteResultMapper.mapToVoteResultList(constituencyDto.getVoteResultsDto())
        );
    }

    public ConstituencyDto mapToConstituencyDto(Constituency constituency) {
        if (constituency == null) {
            return null;
        }
        return new ConstituencyDto(
                constituency.getId(),
                constituency.getName(),
                constituency.getDescription(),
                electionMapper.mapToElectionDto(constituency.getElection()),
                electionListMapper.mapToElectionListDtoList(constituency.getElectionLists()),
                cityMapper.mapToCityDtoList(constituency.getCityList()),
                voteResultMapper.mapToVoteResultDtoList(constituency.getVoteResults())
        );
    }

    public List<ConstituencyDto> mapToConstituencyDtoList(List<Constituency> constituencies) {
        if (constituencies == null) {
            return new ArrayList<>();
        }
        return constituencies.stream()
                .map(constituency -> mapToConstituencyDto(constituency))
                .collect(Collectors.toList());
    }

    public List<Constituency> mapToConstituencyList(List<ConstituencyDto> constituencies) {
        if (constituencies == null) {
            return new ArrayList<>();
        }
        return constituencies.stream()
                .map(constituency -> mapToConstituency(constituency))
                .collect(Collectors.toList());
    }
}
