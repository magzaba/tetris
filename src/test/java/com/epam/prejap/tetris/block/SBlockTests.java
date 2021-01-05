package com.epam.prejap.tetris.block;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = "Block")
public class SBlockTests {

    @Test
    public void blockShouldHaveThreeColumns() {
        SBlock block = new SBlock();
        int expectedNumbersOfColumns = 3;
        Assert.assertEquals(block.cols, expectedNumbersOfColumns, "Block should have three columns");
    }

    @Test
    public void blockShouldHaveTwoRows() {
        SBlock block = new SBlock();
        int expectedNumberOfRows = 2;
        Assert.assertEquals(block.rows, expectedNumberOfRows, "Block should have two rows");
    }

    @Test(dataProvider = "blockPoints")
    public void shouldHaveSShape(int x, int y, int testValue) {
        SBlock block = new SBlock();
        byte blockValue = block.dotAt(x, y);
        Assert.assertEquals(blockValue, testValue, "Block should have different value here");
    }

    @DataProvider()
    public static Object[] blockPoints() {
        return new Object[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 2, 1},
                {1, 0, 1},
                {1, 1, 1},
                {1, 2, 0},
        };
    }
}
