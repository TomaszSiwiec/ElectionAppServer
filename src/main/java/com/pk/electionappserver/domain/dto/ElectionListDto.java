package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.Constituency;
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
    private String name;
    private String description;
    private Constituency constituency;
    private List<Candidate> candidates;
}
