package com.pk.electionappserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "CITIES")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(
            targetEntity = User.class,
            mappedBy = "city",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "CONSTITUENCY_ID")
    private Constituency constituency;
}
