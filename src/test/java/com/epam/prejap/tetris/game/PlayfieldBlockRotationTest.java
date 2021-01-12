package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.block.MockBlockFeeds;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.assertTrue;

@Test(groups = "BlockRotationInGame", dependsOnGroups = "BlockRotation")
public class LBlockRotationInGameTest {

    private static final int GRID_ROWS = 7;
    private static final int GRID_COLUMNS = 5;

    private BlockFeed mockBlockFeed = MockBlockFeeds.lBlockFeed();
    private ByteArrayOutputStream bos;
    private Printer printer;

    @BeforeMethod
    public void setUp() {
        bos = new ByteArrayOutputStream();
        printer = new Printer(new PrintStream(bos), new Timer(1));
    }

    @Test
    public void shallHaveLBlockAtSpawningPosition() {
        // given
        Playfield playfield = new Playfield(GRID_ROWS, GRID_COLUMNS, mockBlockFeed, printer);
        playfield.nextBlock();
        String expectedGrid = """
            +-----+
            | #   |
            | #   |
            | ##  |
            |     |
            |     |
            |     |
            |     |
            +-----+""";

        // when

        // then
        assertTrue(bos.toString().contains(expectedGrid));
    }

    @Test
    public void afterPressingMoveUPOneTimeShallHave90DegreesRotatedLBlockMovedDownOneRow() {
        // given
        Playfield playfield = new Playfield(GRID_ROWS, GRID_COLUMNS, mockBlockFeed, printer);
        playfield.nextBlock();
        String expectedGrid = """
            +-----+
            |     |
            | ### |
            | #   |
            |     |
            |     |
            |     |
            |     |
            +-----+""";

        // when
        playfield.move(Move.UP);

        // then
        assertTrue(bos.toString().contains(expectedGrid));
    }

    @Test
    public void afterPressingMoveUPTwoTimesShallHave180DegreesRotatedLBlockMovedDownTwoRows() {
        // given
        Playfield playfield = new Playfield(GRID_ROWS, GRID_COLUMNS, mockBlockFeed, printer);
        playfield.nextBlock();
        String expectedGrid = """
            +-----+
            |     |
            |     |
            |  ## |
            |   # |
            |   # |
            |     |
            |     |
            +-----+""";

        // when
        playfield.move(Move.UP);
        playfield.move(Move.UP);

        // then
        assertTrue(bos.toString().contains(expectedGrid));
    }

    @Test
    public void afterPressingMoveUPThreeTimesShallHave270DegreesRotatedLBlockMovedDownThreeRows() {
        // given
        Playfield playfield = new Playfield(GRID_ROWS, GRID_COLUMNS, mockBlockFeed, printer);
        playfield.nextBlock();
        String expectedGrid = """
            +-----+
            |     |
            |     |
            |     |
            |     |
            |   # |
            | ### |
            |     |
            +-----+""";

        // when
        playfield.move(Move.UP);
        playfield.move(Move.UP);
        playfield.move(Move.UP);

        // then
        assertTrue(bos.toString().contains(expectedGrid));
    }

    @Test
    public void afterPressingMoveUPFourTimesShallHave360DegreesRotatedLBlockMovedDownFourRows() {
        // given
        Playfield playfield = new Playfield(GRID_ROWS, GRID_COLUMNS, mockBlockFeed, printer);
        playfield.nextBlock();
        String expectedGrid = """
            +-----+
            |     |
            |     |
            |     |
            |     |
            | #   |
            | #   |
            | ##  |
            +-----+""";

        // when
        playfield.move(Move.UP);
        playfield.move(Move.UP);
        playfield.move(Move.UP);
        playfield.move(Move.UP);

        // then
        assertTrue(bos.toString().contains(expectedGrid));
    }

}
