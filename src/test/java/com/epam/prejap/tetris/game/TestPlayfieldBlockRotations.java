package com.epam.prejap.tetris.game;

import com.epam.prejap.tetris.block.BlockFeed;
import com.epam.prejap.tetris.block.TestMockBlockFeed;

record TestPlayfieldBlockRotations(BlockFeed mockBlockfeed,
                                   Object[][] blockRotationsOnGrid,
                                   int gridRows,
                                   int gridColumns) {

    enum TimesUPKeyIsPressed {ZERO, ONE, TWO, THREE, FOUR}

    private static final int GRID_ROWS = 8;
    private static final int GRID_COLUMNS = 6;

    private static final Object[][] I_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO, """
                +------+
                |  #   |
                |  #   |
                |  #   |
                |  #   |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.ONE, """
                +------+
                |      |
                |  ####|
                |      |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.TWO, """
                +------+
                |      |
                |      |
                |  #   |
                |  #   |
                |  #   |
                |  #   |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.THREE, """
                +------+
                |      |
                |      |
                |      |
                |  ####|
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR, """
                +------+
                |      |
                |      |
                |      |
                |      |
                |  #   |
                |  #   |
                |  #   |
                |  #   |
                +------+"""
            },
    };

    private static final Object[][] J_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO, """
                +------+
                |   #  |
                |   #  |
                |  ##  |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.ONE, """
                +------+
                |      |
                |  #   |
                |  ### |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.TWO, """
                +------+
                |      |
                |      |
                |  ##  |
                |  #   |
                |  #   |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.THREE, """
                +------+
                |      |
                |      |
                |      |
                |  ### |
                |    # |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR, """
                +------+
                |      |
                |      |
                |      |
                |      |
                |   #  |
                |   #  |
                |  ##  |
                |      |
                +------+"""
            },
    };

    private static final Object[][] L_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO, """
                +------+
                |  #   |
                |  #   |
                |  ##  |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.ONE, """
                +------+
                |      |
                |  ### |
                |  #   |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.TWO, """
                +------+
                |      |
                |      |
                |  ##  |
                |   #  |
                |   #  |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.THREE, """
                +------+
                |      |
                |      |
                |      |
                |    # |
                |  ### |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR, """
                +------+
                |      |
                |      |
                |      |
                |      |
                |  #   |
                |  #   |
                |  ##  |
                |      |
                +------+"""
            },
    };

    private static final Object[][] O_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO, """
                +------+
                |  ##  |
                |  ##  |
                |      |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.ONE, """
                +------+
                |      |
                |  ##  |
                |  ##  |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.TWO, """
                +------+
                |      |
                |      |
                |  ##  |
                |  ##  |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.THREE, """
                +------+
                |      |
                |      |
                |      |
                |  ##  |
                |  ##  |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR, """
                +------+
                |      |
                |      |
                |      |
                |      |
                |  ##  |
                |  ##  |
                |      |
                |      |
                +------+"""
            },
    };

    private static final Object[][] S_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO, """
                +------+
                |  ##  |
                | ##   |
                |      |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.ONE, """
                +------+
                |      |
                | #    |
                | ##   |
                |  #   |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.TWO, """
                +------+
                |      |
                |      |
                |  ##  |
                | ##   |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.THREE, """
                +------+
                |      |
                |      |
                |      |
                | #    |
                | ##   |
                |  #   |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR, """
                +------+
                |      |
                |      |
                |      |
                |      |
                |  ##  |
                | ##   |
                |      |
                |      |
                +------+"""
            },
    };

    private static final Object[][] Z_BLOCK_ROTATIONS_ON_GRID = new Object[][]{
            {
                    TimesUPKeyIsPressed.ZERO, """
                +------+
                | ##   |
                |  ##  |
                |      |
                |      |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.ONE, """
                +------+
                |      |
                |  #   |
                | ##   |
                | #    |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.TWO, """
                +------+
                |      |
                |      |
                | ##   |
                |  ##  |
                |      |
                |      |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.THREE, """
                +------+
                |      |
                |      |
                |      |
                |  #   |
                | ##   |
                | #    |
                |      |
                |      |
                +------+"""
            },
            {
                    TimesUPKeyIsPressed.FOUR, """
                +------+
                |      |
                |      |
                |      |
                |      |
                | ##   |
                |  ##  |
                |      |
                |      |
                +------+"""
            },
    };

    static TestPlayfieldBlockRotations iBlock() {
        return new TestPlayfieldBlockRotations(
                TestMockBlockFeed.iBlockFeed(),
                I_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

    static TestPlayfieldBlockRotations jBlock() {
        return new TestPlayfieldBlockRotations(
                TestMockBlockFeed.jBlockFeed(),
                J_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

    static TestPlayfieldBlockRotations lBlock() {
        return new TestPlayfieldBlockRotations(
                TestMockBlockFeed.lBlockFeed(),
                L_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

    static TestPlayfieldBlockRotations oBlock() {
        return new TestPlayfieldBlockRotations(
                TestMockBlockFeed.oBlockFeed(),
                O_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

    static TestPlayfieldBlockRotations sBlock() {
        return new TestPlayfieldBlockRotations(
                TestMockBlockFeed.sBlockFeed(),
                S_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

    static TestPlayfieldBlockRotations zBlock() {
        return new TestPlayfieldBlockRotations(
                TestMockBlockFeed.zBlockFeed(),
                Z_BLOCK_ROTATIONS_ON_GRID,
                GRID_ROWS,
                GRID_COLUMNS
        );
    }

}
