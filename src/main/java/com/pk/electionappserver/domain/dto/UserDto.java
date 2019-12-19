package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.Report;
import com.pk.electionappserver.domain.VoteResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;

    private String name;

    private String lastname;

    private String street;

    private long number;

    private long flatNumber;

    private String city;

    private String postcode;

    private String pesel;

    private BigInteger idNumber;

    private String email;

    private String phoneNumber;

    private List<Report> reports;

    private List<VoteResult> voteResults;
}
