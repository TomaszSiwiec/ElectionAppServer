package com.pk.electionappserver.domain;

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
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CITIES_ID")
    private City city;

    @OneToMany(
            targetEntity = VoteResult.class,
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<VoteResult> voteResults;

    private String password;
}
