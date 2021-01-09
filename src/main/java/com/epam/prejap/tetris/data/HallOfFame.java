package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The HallOfFame class represents {@link HallOfFame#name} and {@link HallOfFame#points} of player with highest scores
 * in tetris game.
 *
 * <p>Acts as definition of mapper from JSON using Jackson library.
 */
final class HallOfFame {

    private final String name;

    private final int points;

    @JsonCreator()
    HallOfFame(@JsonProperty("name") final String name,
               @JsonProperty("points") final int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HallOfFame that = (HallOfFame) o;
        return points == that.points && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }
}
