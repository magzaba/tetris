package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.block.MockBlockFeed;

record TestPlayfieldBlockRotations(BlockFeed mockBlockfeed,
                                   Object[][] blockRotationsOnGrid,
                                   int gridRows,
                                   int gridColumns) {

    enum TimesUPKeyIsPressed {ZERO, ONE, TWO, THREE, FOUR}

    private static final int GRID_ROWS = 7;
    private static final int GRID_COLUMNS = 5;

    private static final Object[][] L_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO, """
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
                    TimesUPKeyIsPressed.ONE, """
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
                    TimesUPKeyIsPressed.TWO, """
                +-----+
                |     |
                |     |
                | ##  |
                |  #  |
                |  #  |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.THREE, """
                +-----+
                |     |
                |     |
                |     |
                |   # |
                | ### |
                |     |
                |     |
                +-----+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR, """
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
                    TimesUPKeyIsPressed.ZERO, """
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
                    TimesUPKeyIsPressed.ONE, """
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
                    TimesUPKeyIsPressed.TWO, """
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
                    TimesUPKeyIsPressed.THREE, """
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
                    TimesUPKeyIsPressed.FOUR, """
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

    static TestPlayfieldBlockRotations lBlock() {
        return new TestPlayfieldBlockRotations(
                MockBlockFeed.lBlockFeed(),
                L_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

    static TestPlayfieldBlockRotations oBlock() {
        return new TestPlayfieldBlockRotations(
                MockBlockFeed.oBlockFeed(),
                O_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

}
