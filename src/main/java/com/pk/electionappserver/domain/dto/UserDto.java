package com.pk.electionappserver.domain.dto;

import com.pk.electionappserver.domain.City;
import com.pk.electionappserver.domain.VoteResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private String postcode;

    private String pesel;

    private BigInteger idNumber;

    private String email;

    private String phoneNumber;

    private boolean isAdmin;

    private CityDto city;

    private List<VoteResultDto> voteResults;

    private String password;
}
