package com.cody.codeclash.utils;

import java.util.List;

import com.cody.codeclash.entities.dtos.UserDto;
import com.cody.codeclash.entities.enums.Role;

public class UtilityFunctions {

    public static UserDto getUserDto(){
        // TODO Add user dto
        return new UserDto(
            1L, "user", "email", List.of(Role.USER)
        );
    }

}
