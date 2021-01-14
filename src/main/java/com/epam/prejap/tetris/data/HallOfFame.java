package com.epam.prejap.tetris.data;

import com.epam.prejap.tetris.game.Printer;

import java.util.*;

/**
 * Represents highest number of points in tetris game.
 *
 * @implNote: It contains List with {@link HallOfFameMember} read from file.
 */
public class HallOfFame {

    private final DataReader reader;
    private final DataWriter writer;
    private final Printer printer;

    private List<HallOfFameMember> members;

    public HallOfFame(final DataReader reader, final DataWriter writer, final Printer printer) {
        this.reader = reader;
        this.writer = writer;
        this.printer = printer;
        this.members = obtainMembers();
    }

    public HallOfFame(final DataReader reader, final DataWriter writer, final Printer printer, final List<HallOfFameMember> members) {
        this.reader = reader;
        this.writer = writer;
        this.printer = printer;
        this.members = members;
    }

    private List<HallOfFameMember> obtainMembers() {
        var readList = Arrays.asList(reader.readFromFile());
        return new ArrayList<>(readList);
    }

    /**
     * Try to enter high score {@link HallOfFame} if number of points is sufficient
     *
     * @param points int representing points won in game
     * @return boolean if qualified to enter high scores
     */
    public boolean tryToEnterHallOfFame(final int points, Scanner in) {
        if (members.isEmpty()) {
            return false;
        }
        Optional<HallOfFameMember> anyDefeated = members.stream()
                .filter(e -> e.points() < points)
                .findAny();

        if (anyDefeated.isPresent()) {
            printer.newHighScore(points);
            HallOfFameMember newMember = printer.readInitials(points, in);
            members = enterHallOfFame(newMember);
            return true;
        }
        return false;
    }


    /**
     * Add new member to {@link HallOfFame} and save to file.
     *
     * <p>List of all members is sorted descending by points, saved to file and first 25 elements printed.
     *
     * @param newMember entitled to enter hall of fame
     * @return updated list of members
     */
    List<HallOfFameMember> enterHallOfFame(final HallOfFameMember newMember) {
        members.add(newMember);
        Collections.sort(members);
        writer.writeToFile(members.toArray(HallOfFameMember[]::new));
        printer.hallOfFame(this);
        return members;
    }

    /**
     * Creates String representation of 25 best score members of HallOfFame.
     *
     * @implNote: all members are limited to 25 and printed in format "[number]. Name: [name], Score: [points]".
     *
     * @return String representation of 25 highest scores members.
     */
    @Override
    public String toString() {
        HallOfFameMember[] limitedMembers = limitMembersTo25elements();

        StringBuilder builder = new StringBuilder();
        builder.append("HALL OF FAME\n");
        for (int i = 0; i < limitedMembers.length; i++) {
            int order = i + 1;
            builder.append(order + ". " + limitedMembers[i] + "\n");
        }
        return builder.toString();
    }

    private HallOfFameMember[] limitMembersTo25elements() {
        return members.stream()
                .limit(25)
                .toArray(HallOfFameMember[]::new);
    }

}
