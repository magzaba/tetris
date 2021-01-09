package com.epam.prejap.tetris.data;

import com.epam.prejap.tetris.game.Printer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        return Arrays.asList(reader.readFromFile());
    }

    /**
     * Try to enter high score {@link HallOfFame} if number of points is sufficient
     *
     * @param points
     * @return
     * @throws IOException
     */
    public boolean tryToEnterHallOfFame(final int points) throws IOException {
        Optional<HallOfFameMember> anyDefeated = members.stream()
                .filter(e -> e.points() < points)
                .findAny();

        if (anyDefeated.isPresent()){
            HallOfFameMember newMember = printer.readInitials(points);
            members = enterHallOfFame(newMember);
            return true;
        }
        return false;
    }


    /**
     * Add new member to {@link HallOfFame}.
     *
     * <p>List of members is sorted descending by points and limited to 25 elements. New lists is saved to file.
     *
     * @param newMember entitled to enter hall of fame
     * @return updated list of members
     * @throws IOException if writing to file unsuccessful
     */
    List<HallOfFameMember> enterHallOfFame(final HallOfFameMember newMember) throws IOException {
        members.add(newMember);
        Collections.sort(members);
        var limitedMembers = members.stream()
                .limit(25)
                .toArray(HallOfFameMember[]::new);

        writer.writeToFile(limitedMembers);
        return Arrays.asList(limitedMembers);
    }

}
