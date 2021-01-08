package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HallOfFame {

    private String name;

    private int points;

    @JsonCreator()
    HallOfFame(@JsonProperty("name") final String name,
               @JsonProperty("points") final int points) {
        this.name = name;
        this.points = points;
    }
}
