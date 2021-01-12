package com.epam.prejap.tetris.block;

import org.testng.annotations.Factory;

public class BlockRotationTestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
//                new BlockRotationTest(
//                        new IBlock(),
//                        BlockRotations.I_BLOCK_ROTATION_IMAGES,
//                        BlockRotations.I_BLOCK_ROTATION_POINTS
//                ),
//                new BlockRotationTest(
//                        new JBlock(),
//                        BlockRotations.J_BLOCK_ROTATION_IMAGES,
//                        BlockRotations.J_BLOCK_ROTATION_POINTS
//                ),
                new BlockRotationTest(
                        new LBlock(),
                        BlockRotations.L_BLOCK_ROTATION_IMAGES,
                        BlockRotations.L_BLOCK_ROTATION_POINTS
                ),
//                new BlockRotationTest(
//                        new OBlock(),
//                        BlockRotations.O_BLOCK_ROTATION_IMAGES,
//                        BlockRotations.O_BLOCK_ROTATION_POINTS
//                )
        };
    }

}
