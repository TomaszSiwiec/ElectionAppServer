package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.Constituency;
import com.pk.electionappserver.domain.dto.ConstituencyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConstituencyMapper {
    public Constituency mapToConstituency(ConstituencyDto constituencyDto) {
        return new Constituency(
                0L,
                constituencyDto.getName(),
                constituencyDto.getDescription(),
                constituencyDto.getElection(),
                constituencyDto.getElectionLists()
        );
    }

    public ConstituencyDto mapToConstituencyDto(Constituency constituency) {
        return new ConstituencyDto(
                constituency.getName(),
                constituency.getDescription(),
                constituency.getElection(),
                constituency.getElectionLists()
        );
    }

    public List<ConstituencyDto> mapToConstituencyDtoList(List<Constituency> constituencies) {
        return constituencies.stream()
                .map(constituency -> new ConstituencyDto(
                        constituency.getName(),
                        constituency.getDescription(),
                        constituency.getElection(),
                        constituency.getElectionLists()))
                .collect(Collectors.toList());
    }
}
