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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "ELECTORAL_PARTIES")
public class ElectoralParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(
            targetEntity = Candidate.class,
            mappedBy = "electoralParty",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Candidate> candidates;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "ELECTORAL_PROGRAMMES_ID")
    private ElectoralProgramme electoralProgramme;

    @OneToMany(
            targetEntity = ElectionList.class,
            mappedBy = "electoralParty",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<ElectionList> electionLists;
}
