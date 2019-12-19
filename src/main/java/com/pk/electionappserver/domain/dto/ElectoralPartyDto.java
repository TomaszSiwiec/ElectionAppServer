package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Candidate;
import com.pk.electionappserver.domain.ElectoralProgramme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ElectoralPartyDto {
    private Long id;

    private String name;

    private String description;

    private List<Candidate> candidates;

    private ElectoralProgramme electoralProgramme;
}
