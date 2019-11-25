package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.ElectoralParty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidateDto {
    private String name;
    private String lastname;
    private ElectionList electionList;
    private ElectoralParty electoralParty;
}
