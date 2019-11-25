package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.Election;
import com.pk.electionappserver.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VoteResultDto {
    private User user;
    private Election election;
    private Candidate candidate;
    private LocalDateTime localDateTime;
}
