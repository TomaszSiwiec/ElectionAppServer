package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.ElectionType;
import com.pk.electionappserver.domain.dto.ElectionTypeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElectionTypeMapper {
    public ElectionType mapToElectionType(ElectionTypeDto electionTypeDto) {
        return new ElectionType(
                0L,
                electionTypeDto.getName(),
                electionTypeDto.getElections()
        );
    }

    public ElectionTypeDto mapToElectionTypeDto(ElectionType electionType) {
        return new ElectionTypeDto(
                electionType.getName(),
                electionType.getElections()
        );
    }

    public List<ElectionTypeDto> mapToElectionTypeDtoList(List<ElectionType> electionTypes) {
        return electionTypes.stream()
                .map(electionType -> new ElectionTypeDto(
                        electionType.getName(),
                        electionType.getElections()
                ))
                .collect(Collectors.toList());
    }
}
