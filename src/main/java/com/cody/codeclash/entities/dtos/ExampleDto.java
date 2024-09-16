package com.cody.codeclash.entities.dtos;

import com.google.gson.Gson;

public record ExampleDto(
    String input,
    String output,
    String explanation
) {
    public static ExampleDto from(String input) {
        //  convert json string to ExampleDto
        final Gson gson = new Gson();
        return gson.fromJson(input, ExampleDto.class);
    }
} 
