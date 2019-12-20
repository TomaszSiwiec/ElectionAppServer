package com.pk.electionappserver.domain.dto;

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
