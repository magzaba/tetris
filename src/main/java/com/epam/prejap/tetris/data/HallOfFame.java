package com.epam.prejap.tetris.data;

import com.epam.prejap.tetris.game.Printer;

import java.io.IOException;
import java.util.*;

/**
 * The HallOfFame class represents highest number of points in tetris game.
 *
 * <p>Implementation note: It contains List with {@link HallOfFameMember} read from file.
 */
public class HallOfFame {

    private final DataReader reader;
    private final DataWriter writer;
    private final Printer printer;

    private List<HallOfFameMember> members;

    public HallOfFame(final DataReader reader, final DataWriter writer, final Printer printer) throws IOException {
        this.reader = reader;
        this.writer = writer;
        this.printer = printer;
        this.members = obtainMembers();
    }

    private List<HallOfFameMember> obtainMembers() throws IOException {
        var readList = Arrays.asList(reader.readFromFile());
        return new ArrayList<>(readList);
    }

    /**
     * Try to enter high score {@link HallOfFame} if number of points is sufficient
     *
     * @param points int representing points won in game
     * @return boolean if qualified to enter high scores
     * @throws IOException
     */
    public boolean tryToEnterHallOfFame(final int points) throws IOException {
        Optional<HallOfFameMember> anyDefeated = members.stream()
                .filter(e -> e.points() < points)
                .findAny();

        if (anyDefeated.isPresent()) {
            printer.newHighScore(points);
            HallOfFameMember newMember = printer.readInitials(points);
            members = enterHallOfFame(newMember);
            return true;
        }
        return false;
    }


    /**
     * Add new member to {@link HallOfFame} and save to file.
     *
     * <p>List of members is sorted descending by points, limited to 25 elements and printed.
     *
     * @param newMember entitled to enter hall of fame
     * @return updated list of members
     * @throws IOException if writing to file unsuccessful
     */
    List<HallOfFameMember> enterHallOfFame(final HallOfFameMember newMember) throws IOException {
        members.add(newMember);
        Collections.sort(members);
        writer.writeToFile(members.toArray(HallOfFameMember[]::new));
        var limitedMembers = members.stream()
                .limit(25)
                .toArray(HallOfFameMember[]::new);

        printer.hallOfFame(limitedMembers);
        return Arrays.asList(limitedMembers);
    }

}
