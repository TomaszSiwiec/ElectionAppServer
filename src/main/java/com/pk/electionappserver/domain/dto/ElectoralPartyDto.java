package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.ElectoralProgramme;
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
    private String name;
    private String description;
    private List<Candidate> candidates;
    private ElectoralProgramme electoralProgramme;
}
