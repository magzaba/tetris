package com.epam.prejap.tetris.block;

import org.testng.annotations.Factory;

public class BlockRotationTestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new BlockRotationTest(BlockRotations.iBlock()),
                new BlockRotationTest(BlockRotations.jBlock()),
                new BlockRotationTest(BlockRotations.lBlock()),
                new BlockRotationTest(BlockRotations.oBlock()),
                new BlockRotationTest(BlockRotations.sBlock()),
        };
    }

}
