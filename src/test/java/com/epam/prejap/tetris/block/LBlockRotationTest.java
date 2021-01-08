package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class LBlockRotationTest {

    @DataProvider
    public Object[][] LBlockRotations() {
        return new Object[][] {
                {
                        new byte[][] {
                                {1, 1, 1},
                                {1, 0, 0},
                        }, 1},
                {
                        new byte[][] {
                                {1, 1},
                                {0, 1},
                                {0, 1},
                        }, 2},
                {
                        new byte[][] {
                                {0, 0, 1},
                                {1, 1, 1},
                        }, 3},
                {
                        new byte[][] {
                                {1, 0},
                                {1, 0},
                                {1, 1},
                        }, 4},
        };
    }

    @DataProvider
    public Object[][] LBlockRotationOffsets() {
        return new Object[][] {
                {new Point(0, 0), 1},
                {new Point(0, 1), 2},
                {new Point(1, -1), 3},
                {new Point(-1, 0), 4},
        };
    }

    @Test(dataProvider = "LBlockRotations")
    public void blockImageShouldBeRotated(byte[][] image, int howManyRotations) {
        // given
        var block = new LBlock();
        var blockRotator = new BlockRotator(block);

        // when
        IntStream.range(0, howManyRotations).forEach(i -> blockRotator.rotate());
        var rotatedBlock = blockRotator.getRotatedBlock();

        // then
        for (int i = 0; i < rotatedBlock.rows; i++) {
            for (int j = 0; j < rotatedBlock.cols; j++) {
                assertEquals(image[i][j], rotatedBlock.dotAt(i, j));
            }
        }
    }

    @Test(dataProvider = "LBlockRotationOffsets")
    public void blockOffsetsShouldReflectRotation(Point offset, int howManyRotations) {
        // given
        var block = new LBlock();
        var blockRotator = new BlockRotator(block);

        // when
        IntStream.range(0, howManyRotations).forEach(i -> blockRotator.rotate());
        Point result = blockRotator.getBlockOffset();

        // then
        assertEquals(result, offset);
    }

}
