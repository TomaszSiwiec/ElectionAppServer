package com.pk.electionappserver.electionappserver.domain;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "addressStreet")
    private String addressStreet;

    @Column(name = "addressNumber")
    private String addressNumber;

    @Column(name = "addressFlatBumber")
    private String addressFlatBumber;

    @Column(name = "addressCity")
    private String addressCity;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "reports")
    private List<Report> reports;

    @Column(name = "votesResults")
    private List<VoteResult> voteResults;
}
