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
                0L,
                electionListDto.getName(),
                electionListDto.getDescription(),
                electionListDto.getConstituency(),
                electionListDto.getCandidates()
        );
    }

    public ElectionListDto mapToElectionListDto(ElectionList electionList) {
        return new ElectionListDto(
                electionList.getName(),
                electionList.getDescription(),
                electionList.getConstituency(),
                electionList.getCandidates()
        );
    }

    public List<ElectionListDto> mapToElectionListDtoList(List<ElectionList> electionLists) {
        return electionLists.stream()
                .map(electionList -> new ElectionListDto(
                        electionList.getName(),
                        electionList.getDescription(),
                        electionList.getConstituency(),
                        electionList.getCandidates()))
                .collect(Collectors.toList());
    }
}
