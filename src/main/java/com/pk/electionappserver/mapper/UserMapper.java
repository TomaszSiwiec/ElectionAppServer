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
                0L,
                userDto.getName(),
                userDto.getLastname(),
                userDto.getAddressStreet(),
                userDto.getAddressNumber(),
                userDto.getAddressFlatBumber(),
                userDto.getAddressCity(),
                userDto.getPostcode(),
                userDto.getPesel(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getReports(),
                userDto.getVoteResults()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getName(),
                user.getLastname(),
                user.getAddressStreet(),
                user.getAddressNumber(),
                user.getAddressFlatBumber(),
                user.getAddressCity(),
                user.getPostcode(),
                user.getPesel(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getReports(),
                user.getVoteResults()
        );
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(user -> new UserDto(
                        user.getName(),
                        user.getLastname(),
                        user.getAddressStreet(),
                        user.getAddressNumber(),
                        user.getAddressFlatBumber(),
                        user.getAddressCity(),
                        user.getPostcode(),
                        user.getPesel(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getReports(),
                        user.getVoteResults()
                ))
                .collect(Collectors.toList());
    }
}
