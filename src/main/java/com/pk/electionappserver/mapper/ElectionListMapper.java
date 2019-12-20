package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.dto.ElectionListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectionListMapper {

    @Autowired
    private ConstituencyMapper constituencyMapper;

    @Autowired
    private CandidateMapper candidateMapper;

    public ElectionList mapToElectionList(ElectionListDto electionListDto) {
        return new ElectionList(
                electionListDto.getId(),
                electionListDto.getName(),
                electionListDto.getDescription(),
                constituencyMapper.mapToConstituency(electionListDto.getConstituency()),
                candidateMapper.mapToCadidateList(electionListDto.getCandidates())
        );
    }

    public ElectionListDto mapToElectionListDto(ElectionList electionList) {
        return new ElectionListDto(
                electionList.getId(),
                electionList.getName(),
                electionList.getDescription(),
                constituencyMapper.mapToConstituencyDto(electionList.getConstituency()),
                candidateMapper.mapToCadidateDtoList(electionList.getCandidates())
        );
    }

    public List<ElectionListDto> mapToElectionListDtoList(List<ElectionList> electionLists) {
        return electionLists.stream()
                .map(electionList -> mapToElectionListDto(electionList))
                .collect(Collectors.toList());
    }

    public List<ElectionList> mapToElectionListList(List<ElectionListDto> electionLists) {
        return electionLists.stream()
                .map(electionList -> mapToElectionList(electionList))
                .collect(Collectors.toList());
    }
}
