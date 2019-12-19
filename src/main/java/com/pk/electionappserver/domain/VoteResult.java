package com.pk.electionappserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "VoteResults")
public class VoteResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ELECTIONS_ID")
    private Election election;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "JOIN_VOTERESULTS_CANDIDATES",
            joinColumns = {@JoinColumn(name = "VOTERESULTS_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CANDIDATES_ID", referencedColumnName = "ID")}
    )
    private Candidate candidate;

    private LocalDateTime voteTime;
}
