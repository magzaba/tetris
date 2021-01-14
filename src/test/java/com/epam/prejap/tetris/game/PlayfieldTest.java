package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "Playfield")
public class PlayfieldTest {
    private final int rows = 10;
    private final BlockFeed feed = new BlockFeed();
    private final Printer printer = new Printer(System.out, new Timer(500));
    private Grid grid;
    private Playfield playfield;

    @BeforeMethod
    public void setUp() {
        int cols = 20;
        grid = Grid.getNewGrid(feed, rows, cols, false);
        playfield = new Playfield(feed, printer, grid);
    }

    @Test(dataProvider = "arrayOfMoves", invocationCount = 5)
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

    @Test(dataProvider = "arrayOfMoves", invocationCount = 5)
    public void givenEmptyGrid_noOtherMoveIsValidAfterMoveDOWN(Move move) {
        //given
        playfield.nextBlock();

        //when
        playfield.move(Move.DOWN);

        //then
        Assert.assertFalse(playfield.move(move));
    }

    @DataProvider
    public Object[] arrayOfMoves() {
        return Move.values();
    }

}
