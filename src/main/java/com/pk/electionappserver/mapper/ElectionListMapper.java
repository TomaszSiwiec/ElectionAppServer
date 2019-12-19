package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.dto.ElectionListDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectionListMapper {
    public ElectionList mapToElectionList(ElectionListDto electionListDto) {
        return new ElectionList(
                electionListDto.getId(),
                electionListDto.getName(),
                electionListDto.getDescription(),
                electionListDto.getConstituency(),
                electionListDto.getCandidates()
        );
    }

    public ElectionListDto mapToElectionListDto(ElectionList electionList) {
        return new ElectionListDto(
                electionList.getId(),
                electionList.getName(),
                electionList.getDescription(),
                electionList.getConstituency(),
                electionList.getCandidates()
        );
    }

    public List<ElectionListDto> mapToElectionListDtoList(List<ElectionList> electionLists) {
        return electionLists.stream()
                .map(electionList -> mapToElectionListDto(electionList))
                .collect(Collectors.toList());
    }
}
