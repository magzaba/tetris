package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "Playfield")
public class PlayfieldTest {

    private final static String SCORE_REGEX = "Score: \\d";
    private static final Pattern SCORE_PATTERN = Pattern.compile(SCORE_REGEX);
    private static ByteArrayOutputStream output = new ByteArrayOutputStream();

    private final int rows = 10;
    private final BlockFeed feed = new BlockFeed();
    private final Referee referee = new Referee();
    private final Printer printer = new Printer(new PrintStream(output), new Timer(500), referee);
    private Grid grid;
    private Playfield playfield;


    @BeforeMethod
    public void setUp() {
        int cols = 20;
        grid = Grid.getNewGrid(feed, rows, cols, false);
        playfield = new Playfield(feed, printer, grid, List.of(referee));
    }

    @DataProvider
    public Object[] moveValues() {
        return Move.values();
    }

    @Test(groups = "Playfield", dataProvider = "moveValues", invocationCount = 5)
    public void givenEmptyGrid_moveCalledProperAmountOfTimes(Move move) {
        playfield.nextBlock();
        int blockStart = 0;
        var length = 0;
        var count = 0;

        //finds if playField.nextBlock generates block on Grid byteField
        while (grid.byteGrid[0][blockStart] == 0)
            blockStart++;

        //getLength of block based off starting dot in row 0
        for (int i = 0; i < rows; i++) {
            if (grid.byteGrid[i][blockStart] == 0) {
                if (length == 1)
                    blockStart++;
                else break;
            }
            length++;
        }

        //count expected number of moves to the bottom
        var expectedNrOfMoves = move.equals(Move.DOWN) ? 1 : rows - length;

        //move block down to bottom of grid
        while (playfield.move(move))
            count++;

        assertEquals(count, expectedNrOfMoves, "Block moved an illegal number of turns down");
    }

    @Test(groups = "Playfield", dataProvider = "moveValues", invocationCount = 5)
    public void givenEmptyGrid_noOtherMoveIsValidAfterMoveDOWN(Move move) {
        //given
        playfield.nextBlock();

        //when
        playfield.move(Move.DOWN);

        //then
        Assert.assertFalse(playfield.move(move));
    }

    @Test(groups = "Score")
    public void shouldDisplayScoreUponFirstBlockAppearing() {

        //when
        playfield.nextBlock();
        String actualString = output.toString();

        //then
        assertTrue(SCORE_PATTERN.matcher(actualString).find());
    }

    @Test(groups = "Score", dataProvider = "moveValues")
    public void scoreShouldBeDisplayedAfterMove(Move move) {

        //given
        playfield.nextBlock();

        output.reset();

        //when
        playfield.move(move);
        String actualString = output.toString();

        //then
        assertTrue(SCORE_PATTERN.matcher(actualString).find());
    }
}
