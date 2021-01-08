package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "BlockRotation")
public class BlockRotatorTest {

    @DataProvider
    public Object[][] pointsToRotate() {
        return new Object[][] {
                {new Point(0, 1), new Point(2,3 ), new Point(1, 2)},
                {new Point(1, 2), new Point(3,2 ), new Point(2, 0)},
                {new Point(2, 0), new Point(2,3 ), new Point(0, 0)},
                {new Point(0, 0), new Point(3,2 ), new Point(0, 1)},
        };
    }

    @DataProvider
    public Object[][] middlePointsInImages() {
        return new Object[][] {
                {new byte[3][2], new Point(1, 1)},
                {new byte[2][3], new Point(1, 1)},
                {new byte[4][1], new Point(2, 0)},
                {new byte[1][4], new Point(0, 2)},
        };
    }

    @Test(dataProvider = "pointsToRotate")
    public void shouldRotatePointOnRotatedImage(Point pointToRotate,
                                                Point rotatedImageSize,
                                                Point rotatedPoint) {
        // given
        var blockRotator = new BlockRotator(new OBlock());

        // when
        var result = blockRotator.rotatePointOnRotatedImage(pointToRotate, rotatedImageSize);

        // then
        assertEquals(result, rotatedPoint);
    }

    @Test(dataProvider = "middlePointsInImages")
    public void shouldCalculateRotationPoint(byte[][] image, Point rotationPoint) {
        // given
        var block = new OBlock().copyWithImage(image);
        var blockRotator = new BlockRotator(block);

        // when
        Point result = blockRotator.blockRotationPoint();

        // then
        assertEquals(result, rotationPoint);
    }

    @Test(enabled = false)
    public void shouldRotateBlock90DegreesClockwise() {
        // given
        BlockRotator blockRotator = new BlockRotator(null);
    }


}