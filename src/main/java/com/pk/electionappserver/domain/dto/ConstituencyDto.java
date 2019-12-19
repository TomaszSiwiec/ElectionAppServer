package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Election;
import com.pk.electionappserver.domain.ElectionList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConstituencyDto {
    private Long id;

    private String name;

    private String description;

    private Election election;

    private List<ElectionList> electionLists;
}
