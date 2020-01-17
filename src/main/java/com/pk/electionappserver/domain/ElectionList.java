package com.pk.electionappserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "ELECTION_LISTS")
public class ElectionList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "ELECTION_ID")
    private Election election;

    @ManyToOne
    @JoinColumn(name = "CONSTITUENCY_ID")
    private Constituency constituency;

    @OneToMany(
            targetEntity = Candidate.class,
            mappedBy = "electionList",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Candidate> candidates;
}
