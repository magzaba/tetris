package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class BlockMethodTest {

    @DataProvider
    public static Object[][] casesToTestLowestInColumn() {
        return new Object[][]{
                {new OBlock(), 0, 1},
                {new OBlock(), 1, 1},
                {new LBlock(), 0, 2},
                {new LBlock(), 1, 2},
                {new JBlock(), 0, 2},
                {new JBlock(), 1, 2},
                {new IBlock(), 0, 3},
                {new SBlock(), 0, 1},
                {new SBlock(), 1, 1},
                {new SBlock(), 2, 0},
                {new ZBlock(), 0, 0},
                {new ZBlock(), 1, 1},
                {new ZBlock(), 2, 1},
        };
    }

    @Test(groups = "BlockMethod", dataProvider = "casesToTestLowestInColumn")
    public void shouldReturnCorrectIndexOfLowestOccupiedRowInColumn(Block block, int column, int lowestOccupiedRow) {
        assertEquals(block.lowestOccupiedRowInColumn(column), lowestOccupiedRow);
    }

    @DataProvider
    public static Object[][] casesThatThrowInLowestInColumn() {
        return new Object[][]{
                {new OBlock(), 2},
                {new LBlock(), 3},
                {new JBlock(), 4},
                {new IBlock(), 1},
                {new SBlock(), 4},
                {new ZBlock(), 3},
        };
    }

    @Test(groups = "BlockMethod", expectedExceptions = ArrayIndexOutOfBoundsException.class, dataProvider = "casesThatThrowInLowestInColumn")
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenWrongColumnPassed(Block block, int invalidColumn) {
        block.lowestOccupiedRowInColumn(invalidColumn);
    }
}
