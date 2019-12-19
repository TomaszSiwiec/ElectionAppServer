package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.ElectoralParty;
import com.pk.electionappserver.domain.VoteResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidateDto {
    private Long id;

    private String name;

    private String lastname;

    private String education;

    private String placeOfResidence;

    private VoteResult voteResult;

    private ElectionList electionList;

    private ElectoralParty electoralParty;
}
