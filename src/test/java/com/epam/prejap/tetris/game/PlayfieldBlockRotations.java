package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.block.MockBlockFeed;

record PlayfieldBlockRotations(BlockFeed mockBlockfeed,
                               Object[][] blockRotationsOnGrid,
                               int gridRows,
                               int gridColumns) {

    private enum TimesUPKeyIsPressed {ZERO, ONE, TWO, THREE, FOUR}

    private static final int GRID_ROWS = 7;
    private static final int GRID_COLUMNS = 5;

    private static final Object[][] L_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO.ordinal(), """
                +-----+
                | #   |
                | #   |
                | ##  |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.ONE.ordinal(), """
                +-----+
                |     |
                | ### |
                | #   |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.TWO.ordinal(), """
                +-----+
                |     |
                |     |
                |  ## |
                |   # |
                |   # |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.THREE.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                |     |
                |   # |
                | ### |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                |     |
                | #   |
                | #   |
                | ##  |
                +-----+"""
            },
    };

    private static final Object[][] O_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO.ordinal(), """
                +-----+
                | ##  |
                | ##  |
                |     |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.ONE.ordinal(), """
                +-----+
                |     |
                | ##  |
                | ##  |
                |     |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.TWO.ordinal(), """
                +-----+
                |     |
                |     |
                | ##  |
                | ##  |
                |     |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.THREE.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                | ##  |
                | ##  |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR.ordinal(), """
                +-----+
                |     |
                |     |
                |     |
                |     |
                | ##  |
                | ##  |
                |     |
                +-----+"""
            },
    };

    static PlayfieldBlockRotations lBlock() {
        return new PlayfieldBlockRotations(
                MockBlockFeed.lBlockFeed(),
                L_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

    static PlayfieldBlockRotations oBlock() {
        return new PlayfieldBlockRotations(
                MockBlockFeed.oBlockFeed(),
                O_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

}
