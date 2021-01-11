package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "BlockRotation")
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
    public Object[][] LBlockRotationPoints() {
        return new Object[][] {
                {new ArrayPoint(1, 1), 1},
                {new ArrayPoint(1, 0), 2},
                {new ArrayPoint(0, 1), 3},
                {new ArrayPoint(1, 1), 4},
        };
    }

    @Test(dataProvider = "LBlockRotations")
    public void blockImageShouldBeRotated(byte[][] image, int howManyRotations) {
        // given
        var block = RotatableBlock.of(new LBlock());

        // when
        for (int i = 0; i < howManyRotations; i++) {
            block = block.rotate();
        }

        // then
        for (int i = 0; i < block.rows(); i++) {
            for (int j = 0; j < block.cols(); j++) {
                assertEquals(image[i][j], block.dotAt(i, j));
            }
        }
    }

    @Test(dataProvider = "LBlockRotationPoints")
    public void blockOffsetsShouldReflectRotation(ArrayPoint expectedRotationPoints, int howManyRotations) {
        // given
        var block = RotatableBlock.of(new LBlock());

        // when
        for (int i = 0; i < howManyRotations; i++) {
            block = block.rotate();
        }

        // then
        assertEquals(block.rotationPoint(), expectedRotationPoints);
    }

}
