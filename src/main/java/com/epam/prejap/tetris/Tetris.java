package com.epam.prejap.tetris;

import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.game.*;
import com.epam.prejap.tetris.player.Player;
import com.epam.prejap.tetris.player.RandomPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Tetris {

    private final Playfield playfield;
    private final Waiter waiter;
    private final Player player;
    private final Timer timer;
    private final Referee referee;

    public Tetris(Playfield playfield, Waiter waiter, Player player, Timer timer,
                  Referee referee) {
        this.playfield = playfield;
        this.waiter = waiter;
        this.player = player;
        this.timer = timer;
        this.referee = referee;
    }

    public Score play() {
        boolean moved;
        do {
            moved = false;

            playfield.nextBlock();

            boolean nextMove;
            do {
                waiter.waitForIt();
                timer.tick();
                Move move = player.nextMove().orElse(Move.NONE);
                moved |= (nextMove = playfield.move(move));
            } while (nextMove);

        } while (moved);

        int score = referee.currentScore();

        return new Score(score);
    }

    /**
     * Prepares the environment and launches the game.
     *
     * @param args array of strings input from the command line
     *             <ul>
     *                 <li>args[0] is dedicated to configuring custom navigation keys</li>
     *                 <ul>
     *                     <li>each key should be represented by a single character and separated by space</li>
     *                     <li>input example: "q s d" -> none: q, left: s, right: d</li>
     *                 </ul>
     *             </ul>
     * @see CommandLineAnalyst#checkArgsForNavigationKeys(String)
     */
    public static void main(String[] args) {
        int rows = 10;
        int cols = 20;
        int delay = 500;

        var timer = new Timer(delay);

        var feed = new BlockFeed();
        var referee = new Referee();
        var printer = new Printer(System.out, timer, referee);
        var flagPresent = Arrays.asList(args).contains("-rb") | Arrays.asList(args).contains("-RB");
        var grid = Grid.getNewGrid(feed, rows, cols, flagPresent);

        var playfield = new Playfield(feed, printer, grid, List.of(referee));
        var game = new Tetris(playfield, new Waiter(delay), new RandomPlayer(new Random()), timer,
                referee);

        var score = game.play();

        if (args.length != 0 && !args[0].equalsIgnoreCase("-rb")) {
            CommandLineAnalyst.checkArgsForNavigationKeys(args[0]);
        }

        System.out.println("Total score: " + score.points());
    }
}
