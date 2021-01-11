package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class BlockTest {

    private static final Block oshaped = new OBlock();
    private static final Block lshaped = new LBlock();
    private static final Block ishaped = new IBlock();
    private static final Block brokenBlock = new TestingBlock(new byte[][]{{1,0,1}, {1,0,0}, {1,0,1}});

    @DataProvider
    public static Object[] casesToTestLowestInColumn() {
        return new Object[][]{
                {oshaped, 0, 1},
                {oshaped, 1, 1},
                {lshaped, 0, 2},
                {lshaped, 1, 2},
                {ishaped, 0, 3},
        };
    }

    @Test(groups = "Block", dataProvider = "casesToTestLowestInColumn")
    public void shouldReturnCorrectIndexOfLowestOccupiedRowInColumn(Block block, int column, int lowestOccupiedRow) {
        assertEquals(block.lowestOccupiedRowInColumn(column), lowestOccupiedRow);
    }

    @Test(groups = "Block", expectedExceptions = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {
        brokenBlock.lowestOccupiedRowInColumn(1);
    }

    @Test(groups = "Block", expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsException() {
        oshaped.lowestOccupiedRowInColumn(2);
    }
}
final class TestingBlock extends Block {

    private final byte[][] dots;

    TestingBlock(byte[][] dots) {
        super(dots);
        this.dots=dots;

    }

}
