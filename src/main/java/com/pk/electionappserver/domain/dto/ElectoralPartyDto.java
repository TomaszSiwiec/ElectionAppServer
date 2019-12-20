package com.pk.electionappserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ElectoralPartyDto {
    private Long id;

    private String name;

    private String description;

    private List<CandidateDto> candidates;

    private ElectoralProgrammeDto electoralProgramme;
}
