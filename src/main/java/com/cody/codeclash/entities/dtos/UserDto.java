package com.cody.codeclash.entities.dtos;

import java.util.List;

import com.cody.codeclash.entities.enums.Role;

public record UserDto(
    Long id,
    String username,
    String email,
    List<Role> roles
) {

}
