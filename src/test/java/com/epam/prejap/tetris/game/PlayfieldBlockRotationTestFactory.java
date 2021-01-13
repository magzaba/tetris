package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.MockBlockFeed;
import org.testng.annotations.Factory;

public class PlayfieldBlockRotationTestFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{
                new PlayfieldBlockRotationTest(
                        MockBlockFeed.lBlockFeed(),
                        PlayfieldBlockRotations.L_BLOCK_ROTATIONS_ON_GRID,
                        PlayfieldBlockRotations.GRID_ROWS,
                        PlayfieldBlockRotations.GRID_COLUMNS
                ),
                new PlayfieldBlockRotationTest(
                        MockBlockFeed.oBlockFeed(),
                        PlayfieldBlockRotations.O_BLOCK_ROTATIONS_ON_GRID,
                        PlayfieldBlockRotations.GRID_ROWS,
                        PlayfieldBlockRotations.GRID_COLUMNS
                )
        };
    }



}
