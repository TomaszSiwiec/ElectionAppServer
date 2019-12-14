package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Report;
import com.pk.electionappserver.domain.VoteResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String name;
    private String lastname;
    private String addressStreet;
    private String addressNumber;
    private String addressFlatBumber;
    private String addressCity;
    private String postcode;
    private String pesel;
    private String email;
    private String phoneNumber;
    private List<Report> reports;
    private List<VoteResult> voteResults;
}
