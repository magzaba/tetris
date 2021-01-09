package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The HallOfFame class represents {@link HallOfFameMember#name} and {@link HallOfFameMember#points} of player with highest scores
 * in tetris game.
 *
 * <p>Acts as definition of mapper from JSON using Jackson library.
 *
 * <p>Natural order of objects means descending by points.
 */
public final class HallOfFameMember implements Comparable<HallOfFameMember> {

    private final String name;

    private final int points;

    @JsonCreator()
    public HallOfFameMember(@JsonProperty("name") final String name,
                            @JsonProperty("points") final int points) {
        this.name = name;
        this.points = points;
    }

    public int points() {
        return points;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HallOfFameMember that = (HallOfFameMember) o;
        return points == that.points && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, points);
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Score: " + points;
    }

    /**
     * Compares this object to the other using <strong>reverse</strong> order of {@link Integer#compare(int x, int y)}
     * @param o object to be compared against
     * @return the value {@code 0} if {@code x == y};
     *         a value greater than {@code 0} if {@code x < y}; and
     *         a value less than {@code 0} if {@code x > y}
     */
    @Override
    public int compareTo(final HallOfFameMember o) {
        return Integer.compare(o.points, points);
    }
}
