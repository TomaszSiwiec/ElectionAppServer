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
public class CandidateDto {
    private Long id;

    private String name;

    private String lastname;

    private String education;

    private String placeOfResidence;

    private List<VoteResultDto> voteResults;

    private ElectionListDto electionList;

    private ElectoralPartyDto electoralParty;
}
