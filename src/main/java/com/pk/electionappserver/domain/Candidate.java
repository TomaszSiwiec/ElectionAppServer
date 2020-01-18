package com.pk.electionappserver.domain;

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
@Entity(name = "CANDIDATES")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    @Enumerated(EnumType.STRING)
    private Education education;

    private String placeOfResidence;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "JOIN_VOTERESULTS_CANDIDATES",
            joinColumns = {@JoinColumn(name = "CANDIDATES_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "VOTERESULTS_ID",referencedColumnName = "ID")}
    )
    private List<VoteResult> voteResults;

    @ManyToOne
    @JoinColumn(name = "ELECTION_LISTS_ID")
    private ElectionList electionList;

    @ManyToOne
    @JoinColumn(name = "ELECTORAL_PARTIES_ID")
    private ElectoralParty electoralParty;
}
