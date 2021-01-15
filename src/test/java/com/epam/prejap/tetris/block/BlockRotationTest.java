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

    public BlockRotationTest(BlockRotations blockRotations) {
        this.block = blockRotations.block();
        this.rotationImages = blockRotations.rotationImages();
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
                        "Block image should have been rotated but was not");
            }
        }
    }

    private RotatableBlock rotateBlockByDegrees(RotatableBlock block, RotationDegree degree) {
        for (int i = 0; i < degree.ordinal(); i++) {
            block = block.rotate();
        }
        return block;
    }

}
