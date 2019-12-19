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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "CANDIDATES")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    private String education;

    private String placeOfResidence;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "JOIN_VOTERESULTS_CANDIDATES",
            joinColumns = {@JoinColumn(name = "CANDIDATES_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "VOTERESULTS_ID",referencedColumnName = "ID")}
    )
    private VoteResult voteResult;

    @ManyToOne
    @JoinColumn(name = "ELECTION_LISTS_ID")
    private ElectionList electionList;

    @ManyToOne
    @JoinColumn(name = "ELECTORAL_PARTIES_ID")
    private ElectoralParty electoralParty;
}
