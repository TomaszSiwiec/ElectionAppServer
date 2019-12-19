package com.pk.electionappserver.mapper;

import com.pk.electionappserver.domain.User;
import com.pk.electionappserver.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getLastname(),
                userDto.getStreet(),
                userDto.getNumber(),
                userDto.getFlatNumber(),
                userDto.getCity(),
                userDto.getPostcode(),
                userDto.getPesel(),
                userDto.getIdNumber(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getReports(),
                userDto.getVoteResults()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getStreet(),
                user.getNumber(),
                user.getFlatNumber(),
                user.getCity(),
                user.getPostcode(),
                user.getPesel(),
                user.getIdNumber(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getReports(),
                user.getVoteResults()
        );
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }
}
