package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Election;
import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.dto.ElectionListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectionListMapper {

    @Autowired
    private ConstituencyMapper constituencyMapper;

    @Autowired
    private CandidateMapper candidateMapper;

    @Autowired
    private ElectionMapper electionMapper;

    @Autowired
    private ElectoralPartyMapper electoralPartyMapper;

    public ElectionList mapToElectionList(ElectionListDto electionListDto) {
        if (electionListDto == null) {
            return null;
        }
        return new ElectionList(
                electionListDto.getId(),
                electionListDto.getName(),
                electionListDto.getDescription(),
                electionMapper.mapToElection(electionListDto.getElection()),
                constituencyMapper.mapToConstituency(electionListDto.getConstituency()),
                candidateMapper.mapToCadidateList(electionListDto.getCandidates()),
                electoralPartyMapper.mapToElectoralParty(electionListDto.getElectoralPartyDto())
        );
    }

    public ElectionListDto mapToElectionListDto(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        return new ElectionListDto(
                electionList.getId(),
                electionList.getName(),
                electionList.getDescription(),
                electionMapper.mapToElectionDto(electionList.getElection()),
                constituencyMapper.mapToConstituencyDto(electionList.getConstituency()),
                candidateMapper.mapToCadidateDtoList(electionList.getCandidates()),
                electoralPartyMapper.mapToElectoralPartyDto(electionList.getElectoralParty())
        );
    }

    public List<ElectionListDto> mapToElectionListDtoList(List<ElectionList> electionLists) {
        if (electionLists == null) {
            return new ArrayList<>();
        }
        return electionLists.stream()
                .map(electionList -> mapToElectionListDto(electionList))
                .collect(Collectors.toList());
    }

    public List<ElectionList> mapToElectionListList(List<ElectionListDto> electionLists) {
        if (electionLists == null) {
            return new ArrayList<>();
        }
        return electionLists.stream()
                .map(electionList -> mapToElectionList(electionList))
                .collect(Collectors.toList());
    }
}
