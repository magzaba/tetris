package com.epam.prejap.tetris.game;

import org.testng.annotations.Factory;

public class PlayfieldBlockRotationTestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.lBlock()),
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.oBlock()),
        };
    }


}
