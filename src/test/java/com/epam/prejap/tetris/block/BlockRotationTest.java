package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "BlockRotation", dependsOnGroups = "Block")
public class BlockRotationTest {

    private enum RotationDegree {
        ZERO, NINETY, ONE_HUNDRED_EIGHTY, TWO_HUNDRED_SEVENTY, THREE_HUNDRED_SIXTY
    }

    @DataProvider
    public Object[] rotationDegrees() {
        return RotationDegree.values();
    }

    private final Block block;
    private final Object[] rotationImages;
    private final ArrayPoint[] rotationPoints;

    public BlockRotationTest(BlockRotations blockRotations) {
        this.block = blockRotations.block();
        this.rotationImages = blockRotations.rotationImages();
        this.rotationPoints = blockRotations.rotationPoints();
    }

    @Test(dataProvider = "rotationDegrees")
    public void shallRotateBlockImage(RotationDegree degree) {
        // given
        var block = RotatableBlock.of(this.block);
        var index = degree.ordinal()%rotationImages.length;
        var expectedRotatedImage = (byte[][])rotationImages[index];

        // when
        var rotatedBlock = rotateBlockByDegrees(block, degree);

        // then
        for (int i = 0; i < rotatedBlock.rows(); i++) {
            for (int j = 0; j < rotatedBlock.cols(); j++) {
                assertEquals(rotatedBlock.dotAt(i, j), expectedRotatedImage[i][j],
                        "Block image should have been rotated but did not");
            }
        }
    }

    @Test(dataProvider = "rotationDegrees")
    public void shallRotateBlockRotationPoint(RotationDegree degree) {
        // given
        var block = RotatableBlock.of(this.block);
        var index = degree.ordinal()%rotationPoints.length;
        var expectedRotationPoint = rotationPoints[index];

        // when
        var rotatedBlock = rotateBlockByDegrees(block, degree);

        // then
        assertEquals(rotatedBlock.rotationPoint(), expectedRotationPoint,
                "Block rotation point should have been rotated but did not");
    }

    private RotatableBlock rotateBlockByDegrees(RotatableBlock block, RotationDegree degree) {
        for (int i = 0; i < degree.ordinal(); i++) {
            block = block.rotate();
        }
        return block;
    }

}
