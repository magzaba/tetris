package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.Color;
import com.epam.prejap.tetris.data.HallOfFame;
import com.epam.prejap.tetris.data.HallOfFameMember;

import java.io.PrintStream;
import java.time.Duration;
import java.util.Scanner;

public class Printer {

    private static final String TIME_FORMAT = "%02d:%02d:%02d";
    private static final String BLOCK_MARK = "#";
    final PrintStream out;
    private final Timer timer;

    public Printer(PrintStream out, Timer timer) {
        this.out = out;
        this.timer = timer;
    }

    void draw(byte[][] grid) {
        clear();
        header();
        border(grid[0].length);
        for (byte[] bytes : grid) {
            startRow();
            for (byte aByte : bytes) {
                print(aByte);
            }
            endRow();
        }
        border(grid[0].length);
    }

    void clear() {
        out.print("\u001b[2J\u001b[H");
    }

    /**
     * Print block mark with appropriate color, leave
     * uncoloured empty string in case of zero in game's grid
     *
     * @param colorId   id of specific Color enumeration constant
     * @since           0.8
     * @see             Color
     */
    void print(byte colorId) {
        String colored = Color.of(colorId).applyFor(BLOCK_MARK);
        out.format(colorId == 0 ? " " : colored);
    }

    void startRow() {
        out.print("|");
    }

    void endRow() {
        out.println("|");
    }

    void border(int width) {
        out.println("+" + "-".repeat(width) + "+");
    }

    /**
     * Prints elapsed time in hh:mm:ss format.
     */
    void header() {
        Duration duration = timer.calculateElapsedDuration();
        String elapsedTime = String.format(TIME_FORMAT, duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
        out.println("Time: " + elapsedTime);
    }

    /**
     * Prints HallOfFame members with given boarder",
     */
    public void hallOfFame(HallOfFame hallOfFame) {
        border(20);
        out.println(hallOfFame);
        border(20);
    }

    /**
     * Prints new high score with borders
     *
     * @param score int representing new high score
     */
    public void newHighScore(final int score) {
        String highScore = "NEW HIGH SCORE!";
        border(highScore.length());
        out.println(highScore + "\n" + score);
        border(highScore.length());
    }

    /**
     * Creates new {@link HallOfFameMember} from given players initials and scores,
     * with name limited to max. 3 characters.
     *
     * @param score int representing new high score
     * @param systemName Player name, shall be read from user.name property
     * @return new member of HallOfFame with given initials and score.
     */
    public HallOfFameMember readInitials(final int score, String systemName) {
        out.print("FIRST 3 letters of system name initials saved in HallOfFame");
        if (systemName.length() <= 3) {
            return new HallOfFameMember(systemName, score);

        }
        return new HallOfFameMember(systemName.substring(0, 3), score);
    }

}
