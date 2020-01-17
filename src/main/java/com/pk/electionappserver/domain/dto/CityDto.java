package com.pk.electionappserver.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDto {
    private long id;

    private String name;

    private List<UserDto> users;

    private ConstituencyDto constituency;
}
