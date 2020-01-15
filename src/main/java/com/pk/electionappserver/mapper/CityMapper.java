package com.pk.electionappserver.mapper;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.pk.electionappserver.domain.City;
import com.pk.electionappserver.domain.dto.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ConstituencyMapper constituencyMapper;

    public City mapToCity(CityDto cityDto) {
        if (cityDto == null) {
            return null;
        }
        City city = new City(cityDto.getId(), cityDto.getName(), userMapper.mapToUserList(cityDto.getUsers()), constituencyMapper.mapToConstituency(cityDto.getConstituency()));
        return city;
    }

    public CityDto mapToCityDto(City city) {
        if (city == null) {
            return null;
        }
        CityDto cityDto = new CityDto(city.getId(), city.getName(), userMapper.mapToUserDtoList(city.getUsers()), constituencyMapper.mapToConstituencyDto(city.getConstituency()));
        return cityDto;
    }

    public List<City> mapToCityList(List<CityDto> cityDtos) {
        if (cityDtos == null) {
            return new ArrayList<>();
        }
        return cityDtos.stream()
                .map(cityDto -> mapToCity(cityDto))
                .collect(Collectors.toList());
    }

    public List<CityDto> mapToCityDtoList(List<City> cities) {
        if (cities == null) {
            return new ArrayList<>();
        }
        return cities.stream()
                .map(city -> mapToCityDto(city))
                .collect(Collectors.toList());
    }
}
