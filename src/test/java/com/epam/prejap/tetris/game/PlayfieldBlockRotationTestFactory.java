package com.epam.prejap.tetris.game;

import org.testng.annotations.Factory;

public class PlayfieldBlockRotationTestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.iBlock()),
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.jBlock()),
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.lBlock()),
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.oBlock()),
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.sBlock()),
                new PlayfieldBlockRotationTest(TestPlayfieldBlockRotations.zBlock()),
        };
    }


}
