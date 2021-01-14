package com.epam.prejap.tetris.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * One line in {@link HallOfFame} of our Tetris game, consisting of name and points earned.
 *
 * <p>Acts as definition of mapper from JSON using Jackson library.
 *
 * <p>Natural order of objects means descending by points.
 *
 * @see HallOfFame
 */
record HallOfFameMember(@JsonProperty("name") String name,
                        @JsonProperty("points") int points) implements Comparable<HallOfFameMember> {


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
