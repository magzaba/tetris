package com.epam.prejap.tetris.game;

import org.testng.annotations.Factory;

public class PlayfieldBlockRotationTestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new PlayfieldBlockRotationTest(PlayfieldBlockRotations.lBlock()),
                new PlayfieldBlockRotationTest(PlayfieldBlockRotations.oBlock()),
        };
    }



}
