package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The HallOfFameMember record represents {@link HallOfFameMember#name} and {@link HallOfFameMember#points} of player with highest scores
 * in tetris game.
 *
 * <p>Acts as definition of mapper from JSON using Jackson library.
 *
 * <p>Natural order of objects means descending by points.
 */
public record HallOfFameMember(@JsonProperty("name") String name,
                               @JsonProperty("points") int points) implements Comparable<HallOfFameMember> {


    @Override
    public String toString() {
        return "Name: " + name +
                ", Score: " + points;
    }

    /**
     * Compares this object to the other using <strong>reverse</strong> order of {@link Integer#compare(int x, int y)}
     *
     * @param o object to be compared against
     * @return the value {@code 0} if {@code x == y};
     * a value greater than {@code 0} if {@code x < y}; and
     * a value less than {@code 0} if {@code x > y}
     */
    @Override
    public int compareTo(final HallOfFameMember o) {

        return Integer.compare(o.points, points);
    }
}
