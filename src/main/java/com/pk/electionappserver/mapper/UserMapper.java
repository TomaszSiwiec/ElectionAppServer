package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.User;
import com.pk.electionappserver.domain.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private VoteResultMap voteResultMap;

    public User mapToUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getLastname(),
                userDto.getStreet(),
                userDto.getNumber(),
                userDto.getFlatNumber(),
                userDto.getPostcode(),
                userDto.getPesel(),
                userDto.getIdNumber(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.isAdmin(),
                cityMapper.mapToCity(userDto.getCity()),
                voteResultMap.mapToVoteResultList(userDto.getVoteResults()),
                userDto.getPassword()
        );
    }

    public UserDto mapToUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getStreet(),
                user.getNumber(),
                user.getFlatNumber(),
                user.getPostcode(),
                user.getPesel(),
                user.getIdNumber(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.isAdmin(),
                cityMapper.mapToCityDto(user.getCity()),
                voteResultMap.mapToVoteResultDtoList(user.getVoteResults()),
                user.getPassword()
        );
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        if (users == null) {
            return new ArrayList<>();
        }
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    public List<User> mapToUserList(List<UserDto> users) {
        if (users == null) {
            return new ArrayList<>();
        }
        return users.stream()
                .map(user -> mapToUser(user))
                .collect(Collectors.toList());
    }
}
