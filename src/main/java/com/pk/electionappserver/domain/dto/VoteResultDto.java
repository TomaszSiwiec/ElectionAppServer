package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.Election;
import com.pk.electionappserver.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VoteResultDto {
    private Long id;

    private UserDto user;

    private ElectionDto election;

    private List<CandidateDto> candidates;

    private LocalDateTime voteTime;
}
