package com.pk.electionappserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ElectoralProgrammeDto {
    private Long id;
    private String programDescription;
    private ElectoralPartyDto electoralParty;
}
