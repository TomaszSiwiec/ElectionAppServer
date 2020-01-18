package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.ElectoralParty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ElectionListDto {
    private Long id;

    private String name;

    private String description;

    private ElectionDto election;

    private ConstituencyDto constituency;

    private List<CandidateDto> candidates;

    private ElectoralPartyDto electoralPartyDto;
}
