package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.data.DataReader;
import com.epam.prejap.tetris.data.HallOfFame;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Scanner;

public class Printer {

    private static final String TIME_FORMAT = "%02d:%02d:%02d";
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

    void print(byte dot) {
        out.format(dot == 0 ? " " : "#");
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
     * Prints high scores in format "[number]. Name: [name], Score: [points]".
     */
    void hallOfFame(HallOfFame[] hallOfFames){
        border(25);
        out.println("HALL OF FAME\n");
        for (int i = 0; i < hallOfFames.length; i++) {
            int order = i + 1;
            out.println(order + ". " + hallOfFames[i]);
        }
        border(25);
    }

    /**
     * Prints new high score
     *
     * @param score int representing new high score
     */
    void newHighScore(final int score){
        String highScore = "NEW HIGH SCORE!";
        border(highScore.length());
        out.println(highScore + "\n" + score);
        border(highScore.length());
    }

    /**
     * Reads initials from console, limited to 3 characters
     *
     * @param score int representing new high score
     * @return new member of HallOfFame with param score and input name
     */
    HallOfFame readInitials(final int score) {
        out.print("ENTER YOUR INITIALS [MAX 3]: ");
        Scanner in = new Scanner(System.in);
        String name = in.next(".{1,3}");
        return new HallOfFame(name, score);
    }

}
