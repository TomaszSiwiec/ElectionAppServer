package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectionType;
import com.pk.electionappserver.domain.dto.ElectionTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectionTypeMapper {

    @Autowired
    private ElectionMapper electionMapper;

    public ElectionType mapToElectionType(ElectionTypeDto electionTypeDto) {
        return new ElectionType(
                electionTypeDto.getId(),
                electionTypeDto.getName(),
                electionMapper.mapToElectionList(electionTypeDto.getElections())
        );
    }

    public ElectionTypeDto mapToElectionTypeDto(ElectionType electionType) {
        return new ElectionTypeDto(
                electionType.getId(),
                electionType.getName(),
                electionMapper.mapToElectionDtoList(electionType.getElections())
        );
    }

    public List<ElectionTypeDto> mapToElectionTypeDtoList(List<ElectionType> electionTypes) {
        return electionTypes.stream()
                .map(electionType -> mapToElectionTypeDto(electionType))
                .collect(Collectors.toList());
    }
}
