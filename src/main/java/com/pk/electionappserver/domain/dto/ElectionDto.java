package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Constituency;
import com.pk.electionappserver.domain.ElectionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ElectionDto {
    private LocalDate date;
    private ElectionType electionType;
    private List<Constituency> constituencies;
}
