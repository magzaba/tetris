package com.epam.prejap.tetris.block;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test(groups = "BlockRotation", dependsOnGroups = "BlockShape")
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

    public BlockRotationTest(TestBlockRotations testBlockRotations) {
        this.block = testBlockRotations.block();
        this.rotationImages = testBlockRotations.rotationImages();
    }

    @Test(dataProvider = "rotationDegrees")
    public void shallRotateBlockImage(RotationDegree degree) {
        // given
        var index = degree.ordinal()%rotationImages.length;
        var expectedRotatedImage = (byte[][])rotationImages[index];

        // when
        var rotatedBlock = rotateBlockByDegrees(block, degree);

        // then
        for (int i = 0; i < rotatedBlock.rows(); i++) {
            for (int j = 0; j < rotatedBlock.cols(); j++) {
                assertEquals(rotatedBlock.dotAt(i, j), expectedRotatedImage[i][j],
                        String.format("%s image should have been rotated by %s degrees, but does not.",
                                block.getClass().getSimpleName(), degree.name().toLowerCase()));

            }
        }
    }

    private Block rotateBlockByDegrees(Block block, RotationDegree degree) {
        for (int i = 0; i < degree.ordinal(); i++) {
            block = block.rotate();
        }
        return block;
    }

}
