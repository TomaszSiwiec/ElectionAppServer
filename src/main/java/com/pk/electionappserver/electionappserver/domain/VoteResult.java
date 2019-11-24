package com.pk.electionappserver.electionappserver.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "VotesResults")
public class VoteResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "user")
    private User user;

    @Column(name = "election")
    private Election election;

    @Column(name = "candidate")
    private Candidate candidate;

    @Column(name = "dataTime")
    private LocalDateTime localDateTime;
}
