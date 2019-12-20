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
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "ELECTIONS")
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    @OneToMany(
            targetEntity = VoteResult.class,
            mappedBy = "election",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<VoteResult> voteResults;

    @ManyToOne
    @JoinColumn(name = "ELECTION_TYPES_ID")
    private ElectionType electionType;

    @OneToMany(
            targetEntity = Constituency.class,
            mappedBy = "election",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Constituency> constituencies;
}
