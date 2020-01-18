package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Education;
import com.pk.electionappserver.domain.ElectionList;
import com.pk.electionappserver.domain.ElectoralParty;
import com.pk.electionappserver.domain.VoteResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidateDto {
    private Long id;

    private String name;

    private String lastname;

    private Education education;

    private String placeOfResidence;

    private List<VoteResultDto> voteResultsDto;

    private ElectionListDto electionListDto;

    private ElectoralPartyDto electoralPartyDto;
}
