package com.epam.prejap.tetris.block;

import org.testng.annotations.Factory;

public class BlockRotationTestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new BlockRotationTest(TestBlockRotations.iBlock()),
                new BlockRotationTest(TestBlockRotations.jBlock()),
                new BlockRotationTest(TestBlockRotations.lBlock()),
                new BlockRotationTest(TestBlockRotations.oBlock()),
                new BlockRotationTest(TestBlockRotations.sBlock()),
                new BlockRotationTest(TestBlockRotations.zBlock()),
        };
    }

}
