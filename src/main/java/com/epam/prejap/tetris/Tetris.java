package com.epam.prejap.tetris;

import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.data.DataReader;
import com.epam.prejap.tetris.data.DataWriter;
import com.epam.prejap.tetris.data.HallOfFame;
import com.epam.prejap.tetris.game.*;
import com.epam.prejap.tetris.player.Player;
import com.epam.prejap.tetris.player.RandomPlayer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

class Tetris {

    private static final Path PATH = Paths.get("src/main/resources/files/HallOfFame.txt");

    private final Playfield playfield;
    private final Waiter waiter;
    private final Player player;
    private final Timer timer;

    public Tetris(Playfield playfield, Waiter waiter, Player player, Timer timer) {
        this.playfield = playfield;
        this.waiter = waiter;
        this.player = player;
        this.timer = timer;
    }

    public Score play() {
        boolean moved;
        int score = 0;
        do {
            moved = false;

            playfield.nextBlock();
            score++;

            boolean nextMove;
            do {
                waiter.waitForIt();
                timer.tick();
                Move move = player.nextMove().orElse(Move.NONE);
                moved |= (nextMove = playfield.move(move));
            } while (nextMove);

        } while (moved);

        return new Score(score);
    }

    public static void main(String[] args) throws IOException {
        int rows = 10;
        int cols = 20;
        int delay = 500;

        var timer = new Timer(delay);
        var feed = new BlockFeed();
        var printer = new Printer(System.out, timer);
        var playfield = new Playfield(rows, cols, feed, printer);
        var game = new Tetris(playfield, new Waiter(delay), new RandomPlayer(new Random()), timer);


        var score = game.play();
        System.out.println("Score: " + score.points());

        var reader = new DataReader(PATH);
        var writer = new DataWriter(PATH);
        var hallOfFame = new HallOfFame(reader, writer, printer);
        hallOfFame.tryToEnterHallOfFame(score.points());

    }

}
